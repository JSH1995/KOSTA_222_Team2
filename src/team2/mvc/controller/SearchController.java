
/**
 * @author 김찬원
 * 검색 및 상세 내용 출력을 담당하는 Controller
 * 
 */

package team2.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Search;
import team2.mvc.model.service.SearchService;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;

public class SearchController {

	static SearchService searchService = new SearchService();
	
	
	/**
	 * @author 김찬원
	 * 전체 DB 검색 및 결과를 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param sortType
	 * @return 성공/실패
	 * @exception SQLException, NotFoundException
	 */
	
	
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
	
	/**
	 * @author 김찬원
	 * 작품명을 토대로 검색 및 결과 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param sortType
	 * @param movieName
	 * @return 성공/실패
	 * @exception SQLException, NotFoundException
	 */
	
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
	
	/**
	 * @author 김찬원
	 * 감독명을 토대로 검색 및 결과 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param sortType
	 * @param director
	 * @return 성공/실패
	 * @exception SQLException, NotFoundException
	 */
	
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
	
	/**
	 * @author 김찬원
	 * 배우명을 토대로 검색 및 결과 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param sortType
	 * @param actor
	 * @return 성공/실패
	 * @exception SQLException, NotFoundException
	 */
	
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
	
	/**
	 * @author 김찬원
	 * 장르명을 토대로 검색 및 결과 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param sortType
	 * @param genre
	 * @return 성공/실패
	 * @exception SQLException, NotFoundException
	 */
	
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
	
	/**
	 * @author 김찬원
	 * 국가명을 토대로 검색 및 결과 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param sortType
	 * @param nation
	 * @return 성공/실패
	 * @exception SQLException, NotFoundException
	 */
	
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
	
	/**
	 * @author 김찬원
	 * 영화의 고유번호를 통해 영화 DB 정보를 가져오는 메소드
	 * @param movieNo
	 * @return 특정 영화 DB
	 * @exception SQLException, NotFoundException
	 */
	
	public static Movie searchByPK(int movieNo) {
		
		Movie movie = null;
		
		try {
			movie = searchService.searchByPK(movieNo);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return movie;
	}
	
	/**
	 * @author 김찬원
	 * 영화명을 통해 영화 상세 정보를 가져오는 메소드
	 * @param movieName
	 * @return 특정 영화 DB
	 * @exception SQLException, NotFoundException
	 */
	
	public static Search showMovieDetail(String movieName) {
		
		Search sd = null;
		
		try {
			sd = searchService.showMovieDetail(movieName);
			
			if(sd == null) {
				System.out.println("없는 영화이거나 입력하신 내용이 일치하지 않습니다.");
			}else {
				SuccessView.printMovieDetail(sd);
			}
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return sd;
		
	}
	
	/**
	 * @author 김찬원
	 * 특정 영화에 대한 개인 평점/평가 날짜/코멘트를 출력하는 메소드
	 * @param movieName
	 * @return List<Evaluation>
	 * @exception SQLException, NotFoundException
	 */
	
	public static List<Evaluation> showComment(String movieName){
		
		List<Evaluation> le = null;
		
		try {
			le = searchService.showComment(movieName);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return le;
		
	}
	
}
