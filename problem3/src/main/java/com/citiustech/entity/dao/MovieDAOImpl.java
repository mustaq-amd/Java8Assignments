package com.citiustech.entity.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.citiustech.entity.Movie;
import com.citiustech.utility.HibernateUtil;

public class MovieDAOImpl implements MovieDAO {

	static SessionFactory sessionFactory;
	static Session session;

	static {
		sessionFactory = HibernateUtil.getSessionFactory();

	}

	public List<Movie> getAllMovieDetails(String language) {

		session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = " FROM Movie M WHERE M.language = :language";
		Query<Movie> query = session.createQuery(hql);
		query.setParameter("language", language);
		List<Movie> movie = query.getResultList();

		session.close();
		return movie;
	}

	public List<Movie> getAllMovieByDirector(Integer directorId) {

		session = sessionFactory.openSession();
		session.beginTransaction();

//		String hql = "SELECT Movie.movieId,Movie.language,Movie.name,Movie.releasedIn,Movie.revenueDollers\r\n"
//				+ "FROM Movie\r\n"
//				+ "INNER JOIN Director ON Movie.directorId=Director.directorId WHERE Director.directorName='Rajamouli'";
		
		String hql = "from Movie where directorId=:directorId";
		Query query = session.createQuery(hql);
		query.setParameter("directorId", directorId);
		List<Movie> movie = query.getResultList();

		session.close();
		return movie;
	}

	public Movie addMovies(Movie movie) throws Exception {
		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(movie);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("Movie is not added");
		} finally {
			session.close();
		}
		return movie;
	}

	public void updateRevenue(Integer movieId) {
		
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "UPDATE Movie M set M.revenueDollers = M.revenueDollers + 100000 WHERE M.movieId = :movieId";
		Query q = session.createQuery(hql);
		q.setParameter("movieId", movieId);
		
		q.executeUpdate();
		session.getTransaction().commit();
		
		session.close();

	}

	public void deleteMovie(String movieName) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query q = session.createQuery("delete from Movie M where M.name= :name");
		q.setParameter("name", movieName);
		
		q.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	public List<String> getDistinctLanguages() {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT DISTINCT(language) FROM Movie");
		List<String> resultList = q.getResultList();
		
		session.close();
		return resultList;
	}

	public Map<Object, Object> getMovieNameDirectorName() {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Map<Object, Object> map = new LinkedHashMap<>();
		Query q = session.createQuery("select m.name, m.director.directorName from Movie m");
		List<String[]> list = q.list();
		
		for (Object[] str : list) {
			map.put(str[0], str[1]);
		}
		session.close();
		return map;
	}

}
