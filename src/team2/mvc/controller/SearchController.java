
/**
 * @author 김찬원
 * 
 * 
 */


package team2.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Search;
import team2.mvc.model.service.SearchService;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;

public class SearchController {

	static SearchService searchService = new SearchService();
	
	public static boolean searchAll(String sortType) {
		
		try {
			List<Search> searchList = searchService.searchAll(sortType);
			SuccessView.printMovieList(searchList);
			return true;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		

		return false;
	}
	
	public static boolean searchByName(String movieName, String sortType) {
		
		try {
			List<Search> searchList = searchService.searchByName(movieName, sortType);
			SuccessView.printMovieList(searchList);
			return true;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public static boolean searchByDirector(String director, String sortType) {
		
		try {
			List<Search> searchList = searchService.searchByDirector(director, sortType);
			SuccessView.printMovieList(searchList);
			return true;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public static boolean searchByActor(String actor, String sortType) {
		
		try {
			List<Search> searchList = searchService.searchByActor(actor, sortType);
			SuccessView.printMovieList(searchList);
			return true;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public static boolean searchByGenre(String genre, String sortType) {
		
		try {
			List<Search> searchList = searchService.searchByGenre(genre, sortType);
			SuccessView.printMovieList(searchList);
			return true;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public static boolean searchByNation(String nation, String sortType) {
		
		try {
			List<Search> searchList = searchService.searchByNation(nation, sortType);
			SuccessView.printMovieList(searchList);
			return true;
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return false;
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
	
	public static Search showMovieDetail(String movieName) {
		
		Search sd = null;
		
		try {
			sd = searchService.showMovieDetail(movieName);
			SuccessView.printMovieDetail(sd);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return sd;
		
	}
	
	public static List<Evaluation> showComment(String movieName){
		
		List<Evaluation> le = null;
		
		try {
			le = searchService.showComment(movieName);
			SuccessView.printComment(le);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return le;
		
	}
	
}
