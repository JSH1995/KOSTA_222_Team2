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
	
	public static void viewWishList(int userNo) {
		try {
			List<Movie> movieList = wishService.viewWishList(userNo);
			SuccessView.printWishList(movieList);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}		
	}
	
	public static void putWishList(int userNo, int movieNo) {
		try {
			wishService.putWishList(userNo, movieNo);
			SuccessView.messagePrint("정상적으로 등록되었습니다.");
		}catch (Exception e) {
			FailView.errorMessage("이미 위시리스트에 존재하는 영화입니다.");
		}
	}
}
