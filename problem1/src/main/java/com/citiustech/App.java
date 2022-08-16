package com.citiustech;

import java.util.Scanner;

import com.citiustech.dao.MovieDao;
import com.citiustech.dao.MovieDaoImpl;
import com.citiustech.entity.Movie;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello");

		Scanner sc = new Scanner(System.in);
		MovieDao movieDao = new MovieDaoImpl();
		System.out.println("Hello 2");
		int input = 5;
		do {
			System.out.println("\nChoose an option");
			System.out.println("1. Add Movie\n2. Update Movie\n3. Delete Movie\n4. Get Movie Details\n0. Exit");
			input = sc.nextInt();
			switch (input) {
			case 0:
				break;
			case 1:

				System.out.println("Enter Movie id");
				int movieId = sc.nextInt();
				System.out.println("Enter Movie Name");
				String name = sc.next();
				System.out.println("Enter Language");
				String language = sc.next();
				System.out.println("Release In ?");
				int releasedIn = sc.nextInt();
				System.out.println("Revenue Dollars ? ");
				int revenueDollers = sc.nextInt();

				Movie movie = new Movie(movieId, name, language, releasedIn, revenueDollers);
				String moviId = movieDao.addMovie(movie);
				
				System.out.println("Movie added Successfully.."+moviId);
				
				break;
			case 2:
				System.out.println("Enter the movie Id: ");
				int id = sc.nextInt();
				movieDao.updateMovie(id);
				break;
			case 3:
				System.out.println("Enter the Movie Id: ");
				int mid = sc.nextInt();
				movieDao.deleteMovie(mid);
				break;
			case 4:
				System.out.println("Enter the Movie Id: ");
				int mId = sc.nextInt();
				Movie movieDetail = movieDao.getMovieDetails(mId);
//				if (movieDetail == null)
//					System.out.println("No records found for the id: " + mId);
//				else
				System.out.println(movieDetail);
				break;
			default:
				System.out.println("Enter a valid number between 0 to 4");
				break;
			}

		} while (input != 0);
	}
}
