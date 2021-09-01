
/**
 * 기능 성공 시 결과 출력을 해주는 메소드
 * 
 */

package team2.mvc.view;

import java.util.List;

import team2.mvc.model.dto.Search;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Movie;

public class SuccessView {

	/**
	 * 기능 성공에 대한 메시지 출력 메소드
	 * @param message
	 */

	public static void messagePrint(String message) {
		System.out.println(message);
	}

	/**
	 * 위시리스트를 출력하는 메뉴
	 * @param movieList
	 */
	public static void printWishList(List<Movie> movieList) {
		for (Movie m : movieList) {
			System.out.println(m);
		}
	}

	/**
	 * 추천 영화 리스트를 출력하는 메뉴
	 * @param list
	 */
	
	public static void printRecMovieList(List<Movie> list) {
		for (Movie m : list) {
			System.out.println(m);
		}
	}

	/**
	 * 검색 결과에 의한 리스트 출력 메소드
	 * @param searchList
	 */
	
	public static void printMovieList(List<Search> searchList) {

		for (Search search : searchList) {
			System.out.println(search);
		}
	}
	
	/**
	 * 검색 결과에 의한 영화 상세 정보를 출력하는 메소드
	 * @param sd
	 */

	public static void printMovieDetail(Search sd) {
		System.out.println(sd);
	}
	
	/**
	 * 개인 평점 / 평가 날짜 / 코멘트를 의한 영화 상세 정보를 출력하는 메소드
	 * @param sd
	 */
	public static void printComment(List<Evaluation> le) {
		System.out.println(le);
	}

}
