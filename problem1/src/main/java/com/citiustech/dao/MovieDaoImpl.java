package com.citiustech.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.citiustech.entity.Movie;
import com.citiustech.exception.MovieException;

public class MovieDaoImpl implements MovieDao {

	static SessionFactory sessionFactory;
	static Session session;

	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}

	public String addMovie(Movie movie) throws MovieException {
		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(movie);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new MovieException("Movie is not added");
		} finally {
			session.close();
		}
		return movie.getMovieId().toString();
	}

	public void deleteMovie(Integer id) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Movie movie = getMovieDetails(id);
		if (movie != null) {
			session.remove(movie);
			session.getTransaction().commit();
			System.out.println("Movie Deleted Successfullyy..");
		}
		session.close();

	}

	public void updateMovie(Integer id) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		Movie existingMovie = getMovieDetails(id);

		Integer updatedRevenue = existingMovie.getRevenueDollers() + 100000;
		existingMovie.setRevenueDollers(updatedRevenue);

		session.update(existingMovie);
		session.getTransaction().commit();

		System.out.println("Movie Updated Successfullyy..");
		
		session.close();

	}

	public Movie getMovieDetails(Integer id) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Movie movie = session.get(Movie.class, id);
		if (movie == null) {
			throw new MovieException("Movie not found with id :" + id);
		}
		
		return movie;
	}

}
