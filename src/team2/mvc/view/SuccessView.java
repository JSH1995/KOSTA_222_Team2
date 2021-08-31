package team2.mvc.view;

import java.util.List;

import team2.mvc.model.dto.Search;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Movie;

public class SuccessView {

	public static void messagePrint(String message) {
		System.out.println(message);
	}

	/**
	 * 위시리스트를 출력하는 메뉴
	 * 
	 * @param movieList
	 */
	public static void printWishList(List<Movie> movieList) {
		for (Movie m : movieList) {
			System.out.println(m);
		}
	}

	public static void printRecMovieList(List<Movie> list) {
		for (Movie m : list) {
			System.out.println(m);
		}
	}

	public static void printMovieList(List<Search> searchList) {

		for (Search search : searchList) {
			System.out.println(search);
		}
	}

	public static void printMovieDetail(Search sd) {
		System.out.println(sd);
	}

	public static void printComment(List<Evaluation> le) {
		System.out.println(le);
	}

}
