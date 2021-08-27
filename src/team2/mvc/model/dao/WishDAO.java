package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;

public interface WishDAO {

	/**
	 * 위시리스트 목록 보기
	 * */
	List<Movie> viewWishList(int userNo) throws SQLException;

	/**
	 * 위시리스트에 영화 추가하기
	 * */
	int putWishList(int userNo, int movieNo) throws SQLException;

}
