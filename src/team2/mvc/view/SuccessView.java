package team2.mvc.view;

import java.util.List;

import team2.mvc.model.dto.Movie;

public class SuccessView {
	
	public static void messagePrint(String message) {
		System.out.println(message);
	}

	public static void printWishList(List<Movie> movieList) {
		for(Movie m : movieList) {
			System.out.println(movieList);
		System.out.println(movieList);
	 }
	}

	public static void printMovieList(List<Movie> movieList) {
		
		for(Movie movie : movieList) {
			System.out.println(movie);
		}
	}


}
