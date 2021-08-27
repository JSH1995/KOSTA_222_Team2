package team2.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.SearchService;
import team2.mvc.model.service.WishService;
import team2.mvc.view.FailView;


public class WishController {
	private static WishService wishService = new WishService();
	
	public static void putWishList(int userNo, int movieNo) {
		
		try {
			wishService.putWishList(userNo, movieNo);
					
			List<Movie> movieList = new ArrayList<Movie>();
		
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	
	public static void viewWishList(int userNo) {
		try {
			List<Movie> movieList = wishService.viewWishList( userNo);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
		
		
	}
}
