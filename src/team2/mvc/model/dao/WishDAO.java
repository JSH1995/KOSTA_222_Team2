package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.exception.DuplicateException;
import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dto.Movie;

public interface WishDAO {

	/**
	 * 위시리스트 목록 보기
	 * */
	List<Movie> viewWishList(int userNo) throws SQLException, NotFoundException;

	/**
	 * 위시리스트에 영화 추가하기
	 * @throws DuplicateException 
	 * */
	void putWishList(int userNo, int movieNo) throws SQLException, DuplicateException;

}
