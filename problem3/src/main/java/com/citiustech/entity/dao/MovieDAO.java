package com.citiustech.entity.dao;

import java.util.List;
import java.util.Map;

import com.citiustech.entity.Movie;

public interface MovieDAO {

	List<Movie> getAllMovieDetails(String language);

	List<Movie> getAllMovieByDirector(Integer directorId);

	Movie addMovies(Movie movie) throws Exception;

	void updateRevenue(Integer movieId);

	void deleteMovie(String movieName);

	List<String> getDistinctLanguages();

	Map<Object, Object> getMovieNameDirectorName();

}
