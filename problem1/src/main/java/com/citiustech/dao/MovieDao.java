package com.citiustech.dao;

import com.citiustech.entity.Movie;
import com.citiustech.exception.MovieException;

public interface MovieDao {
	
	public String addMovie(Movie movie) throws MovieException;

	public void deleteMovie(Integer id);

	public void updateMovie(Integer id);

	public Movie getMovieDetails(Integer id);

}
