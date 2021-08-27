package team2.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.SearchService;
import team2.mvc.model.service.WishService;
import team2.mvc.view.FailView;


public class WishController {
	private static SearchService searchService = new SearchService();
	private static WishService wishServie = new WishService();
	
	public static void putWishList(int userNo, int movieNo) {
		
		try {
			Movie movie = searchService.searchByPK(movieNo);
					
			List<Movie> movieList = new ArrayList<Movie>();
			if(!movieList.contains(movie)) {
				movieList.add(movie);
			}else
				System.out.println("이미 추가된 영화입니다.");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	
	public static void viewWishList(int userNo, int movieNo) {
		try {
			List<Movie> movieList = wishServie.viewWishList( userNo,  movieNo);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
		
		
	}
}
