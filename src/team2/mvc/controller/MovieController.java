package team2.mvc.controller;

import java.sql.SQLException;

import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Tag;
import team2.mvc.model.service.MovieService;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;

public class MovieController {
	
	static MovieService movieService = new MovieService();

	
	/**
	 * 영화 등록
	 * */
	public static void registerMovie(int movieNo, int genreNo, String movieName, String director, String date1) {
		try {
			movieService.registerMovie(movieNo, genreNo, movieName, director, date1);
			SuccessView.messagePrint("등록되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	} 
	
	/**
	 * 영화 수정
	 * */
	public static void updateMovie(int movieNo, int genreNo, String movieName, String director, String date1) {
		try {
			movieService.updateMovie(movieNo, genreNo, movieName, director, date1);
			SuccessView.messagePrint("수정되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 영화 삭제
	 * */
	public static void deleteMovie(int movieNo) {
		try {
			movieService.deleteMovie(movieNo);
			SuccessView.messagePrint("삭제되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 배우 등록 
	 * */
	public static void registerActor(Actor actor) {
		try {
			movieService.registerActor(actor);
			SuccessView.messagePrint("등록되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	
	/**
	 * 배우 수정
	 * */
	
	public static void updateActor(Actor actor) {
		try {
			movieService.updateActor(actor);
			SuccessView.messagePrint("수정되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 배우 삭제
	 * */
	
	public static void deleteActor(int movieNo) {
		try {
			movieService.deleteActor(movieNo);
			SuccessView.messagePrint("삭제되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 태그 등록
	 * */
	public static void registerTag(Tag tag) {
		try {
			movieService.registerTag(tag);
			SuccessView.messagePrint("등록되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 태그 수정
	 * */
	
	public static void updateTag(Tag tag) {
		try {
			movieService.updateTag(tag);
			SuccessView.messagePrint("수정되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 태그 삭제
	 * */
	public static void deleteTag(int movieNo) {
		try {
			movieService.deleteTag(movieNo);
			SuccessView.messagePrint("삭제되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 영화상세정보 등록
	 * */
	public static void registerMovieDetail(MovidDetail movieDetail) {
		try {
			movieService.registerMovieDetail(movieDetail);
			SuccessView.messagePrint("등록되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 영화상세정보 수정
	 * */
	
	public static void updateMovieDetail(MovidDetail movieDetail) {
		try {
			movieService.updateMovieDetail(movieDetail);
			SuccessView.messagePrint("수정되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 영화상세정보 삭제
	 * */
	public static void deleteMovieDetail(int movieNo) {
		try {
			movieService.deleteMovieDetail(movieNo);
			SuccessView.messagePrint("삭제되었습니다.");
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	

}
