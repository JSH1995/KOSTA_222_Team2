package team2.mvc.controller;

import java.sql.SQLException;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.MovieService;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;

public class MovieController {
	
	static MovieService movieService = new MovieService();

	
	/**
	 * 영화 등록
	 * */
	public static void registerMovie(Movie movie) {
		try {
			movieService.movieInsert(movie);
			SuccessView.messagePrint("등록되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 영화 수정
	 * */
	public static void updateMovie(Movie movie) {
		try {
			movieService.movieUpdate(movie);
			SuccessView.messagePrint("수정되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 영화 삭제
	 * */
	public static void deleteMovie(Movie movie) {
		try {
			movieService.movieDelete(movie);
			SuccessView.messagePrint("삭제되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}

}
