package team2.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.SearchService;
import team2.mvc.model.service.WishService;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;

public class WishController {
	private static WishService wishService = new WishService();
	
	/**
	 * 사용자 고유넘버를 받아 위시리스트를 출력
	 * @author 홍전형
	 * @param userNo
	 */
	public static void viewWishList(int userNo) {
		try {
			List<Movie> movieList = wishService.viewWishList(userNo);
			SuccessView.printWishList(movieList);
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}		
	}
	/**
	 * 위시리스트에 영화를 추가하는 메서드
	 * @author 홍전형
	 * @param userNo, movieNo
	 */
	public static void putWishList(int userNo, int movieNo) {
		try {
			wishService.putWishList(userNo, movieNo);
			SuccessView.messagePrint("정상적으로 등록되었습니다.");
		}catch (Exception e) {
			FailView.errorMessage("이미 위시리스트에 존재하는 영화입니다.");
		}
	}
}
