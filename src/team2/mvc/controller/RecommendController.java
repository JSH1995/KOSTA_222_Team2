package team2.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.RecommendService;
import team2.mvc.view.FailView;
import team2.mvc.view.MenuView;
import team2.mvc.view.SuccessView;

public class RecommendController {
	static RecommendService recommendService = new RecommendService();

	/**
	 * 해당 나이대에 가장 많이 위시리스트에 담긴 영화를 추천 
	 * @param age
	 */
	public static void recByAge(int age) {
		try {
			List<Movie> list = recommendService.recByAge(age);
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());		}
	}

	public static void recByRank() {
		try {
			List<Movie> list = recommendService.recByRank();
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());		}
	}

	public static void recByGenre(int userNo) {
		try {
			List<Movie> list = recommendService.recByGenre(userNo);
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());		}
	}

	public static void recByTag(int userNo) {
		try {
			List<Movie> list = recommendService.recByTag(userNo);
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
