
/**
 * @author 김찬원
 * 
 * 
 */


package team2.mvc.controller;

import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.SearchService;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;

public class SearchController {

	static SearchService searchService = new SearchService();
	
	public static void searchAll() {
		
		try {
			List<Movie> movieList = searchService.searchAll();
			SuccessView.printMovieList(movieList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	public static Movie searchByPK(int movieNo) {
		
		Movie movie = null;
		
		try {
			movie = searchService.searchByPK(movieNo);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return movie;
	}
	
	
}
