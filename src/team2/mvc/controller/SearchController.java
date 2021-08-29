
/**
 * @author 김찬원
 * 
 * 
 */


package team2.mvc.controller;

import java.util.List;

import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.SearchService;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;

public class SearchController {

	static SearchService searchService = new SearchService();
	
	public static void searchAll(String sortType) {
		
		try {
			List<Movie> movieList = searchService.searchAll(sortType);
			SuccessView.printMovieList(movieList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	public static void searchByName(String movieName, String sortType) {
		
		try {
			List<Movie> movieList = searchService.searchByName(movieName, sortType);
			SuccessView.printMovieList(movieList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void searchByDirector(String director, String sortType) {
		
		try {
			List<Movie> movieList = searchService.searchByDirector(director, sortType);
			SuccessView.printMovieList(movieList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void searchByActor(String actor, String sortType) {
		
		try {
			List<Movie> movieList = searchService.searchByActor(actor, sortType);
			SuccessView.printMovieList(movieList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void searchByGenre(String genre, String sortType) {
		
		try {
			List<Movie> movieList = searchService.searchByGenre(genre, sortType);
			SuccessView.printMovieList(movieList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void searchByNation(String nation, String sortType) {
		
		try {
			List<Movie> movieList = searchService.searchByNation(nation, sortType);
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
	
	public static MovidDetail showMovieDetail(String movieName) {
		
		MovidDetail md = null;
		
		try {
			md = searchService.showMovieDetail(movieName);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return md;
		
	}
	
}
