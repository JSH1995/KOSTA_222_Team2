package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.exception.DuplicateException;
import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dto.Movie;

public interface WishDAO {

	/**
	 * 사용자 고유넘버를 받아 위시리스트를 출력
	 * */
	List<Movie> viewWishList(int userNo) throws SQLException, NotFoundException;

	/**
	 * 위시리스트에 영화를 추가
	 * @throws DuplicateException 
	 * */
	void putWishList(int userNo, int movieNo) throws SQLException, DuplicateException;

}
