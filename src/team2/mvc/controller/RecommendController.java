
/**
 * @author 홍전형
 * 위시리스트 기반 추천 영화 리스트를 제공하는 Controller 클래스
 * 
 */


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
	 * @author 홍전형
	 * 해당 나이대에 가장 많이 위시리스트에 담긴 영화를 추천 
	 * @param age
	 * @exception SQLException, NotFoundException
	 */
	public static void recByAge(int age) {
		try {
			List<Movie> list = recommendService.recByAge(age);
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());		}
	}
	
	/**
	 * @author 홍전형
	 * 가장 많이 위시리스트에 담긴 영화를 추천 
	 * @exception SQLException, NotFoundException
	 */

	public static void recByRank() {
		try {
			List<Movie> list = recommendService.recByRank();
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());		}
	}
	
	/**
	 * @author 홍전형
	 * @param 유저 고유번호
	 * 좋아하는 장르의 영화를 추천 
	 * @exception SQLException, NotFoundException
	 */

	public static void recByGenre(int userNo) {
		try {
			List<Movie> list = recommendService.recByGenre(userNo);
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());		}
	}
	
	/**
	 * @author 홍전형
	 * @param 유저 고유번호
	 * 좋아하는 태그의 영화를 추천 
	 * @exception SQLException, NotFoundException
	 */


	public static void recByTag(int userNo) {
		try {
			List<Movie> list = recommendService.recByTag(userNo);
			SuccessView.printRecMovieList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
