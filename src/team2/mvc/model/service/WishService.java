package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.exception.DuplicateException;
import team2.mvc.model.dao.WishDAO;
import team2.mvc.model.dao.WishDAOlmpl;
import team2.mvc.model.dto.Movie;

public class WishService {
	WishDAO wishDAO = new WishDAOlmpl();

	public List<Movie> viewWishList(int userNo) throws SQLException {
			List<Movie> movieList = wishDAO.viewWishList(userNo);
			if(movieList==null || movieList.isEmpty()) {
				throw new SQLException("위시리스트가 없습니다.");
			}
		return movieList;
	}
	
	public void putWishList(int userNo, int movieNo) throws SQLException, DuplicateException {
		wishDAO.putWishList(userNo, movieNo);
	}
}
