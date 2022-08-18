package com.citiustech;


import java.util.List;
import java.util.Map;

import com.citiustech.entity.Movie;
import com.citiustech.entity.dao.MovieDAO;
import com.citiustech.entity.dao.MovieDAOImpl;

/**
 * Hello world!
 *
 */
public class App {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		 MovieDAO movieDAO = new MovieDAOImpl();
		 
		 
		 
		 //Get Movies By Language
		 List<Movie> movieList = movieDAO.getAllMovieDetails("Telugu");
		 movieList.forEach(System.out::println);
		 
		 //Get Movies By Director Name
		 List<Movie> movieList1 = movieDAO.getAllMovieByDirector(22);
		 for(Movie movie : movieList1) {
			 System.out.println((movie));
		 }
		 
		 
		 //Add Movie
		 
	/*
		 Movie movie1 = new Movie();
		 movie1.setName("Bahubali 1");
		 movie1.setLanguage("Telugu");
		 movie1.setReleasedIn(2013);
		 movie1.setRevenueDollers(70000);
		 
		 Movie movie2 = new Movie();
		 movie2.setName("Bahubali 2");
		 movie2.setLanguage("Telugu");
		 movie2.setReleasedIn(2017);
		 movie2.setRevenueDollers(90000);
		 
		 Director director = new Director();
		 director.setDirectorName("Rajamouli");	
		 director.setBornIn(1986);
		 
		 movie1.setDirector(director);
		 movie2.setDirector(director);
		 
		 try {
			movieDAO.addMovies(movie1);
			movieDAO.addMovies(movie2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 */
		 
		 //Update Movie
		 movieDAO.updateRevenue(21);
		 
		 //Delete Movie
		 movieDAO.deleteMovie("Bahubali");
		 
		 //Distinct language
		 
		 List<String> list= movieDAO.getDistinctLanguages();
		 System.out.println(list);
		 
		 Map<Object, Object> map = movieDAO.getMovieNameDirectorName();
		 System.out.println(map);
		 
	

	}
}
