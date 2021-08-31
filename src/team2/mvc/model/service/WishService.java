package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.exception.DuplicateException;
import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dao.WishDAO;
import team2.mvc.model.dao.WishDAOlmpl;
import team2.mvc.model.dto.Movie;

public class WishService {
	WishDAO wishDAO = new WishDAOlmpl();
	/**
	 * 위시리스트 보는 메소드
	 * @author 홍전형
	 * @param userNo
	 * @throws SQLException
	 * @throws NotFoundException
	 */
	public List<Movie> viewWishList(int userNo) throws SQLException, NotFoundException {
			List<Movie> movieList = wishDAO.viewWishList(userNo);
			if(movieList==null || movieList.isEmpty()) {
				throw new NotFoundException("위시리스트가 없습니다.");
			}
		return movieList;
	}
	/**
	 * 사용자 위시리스트에 넣는 메소드
	 * @author 홍전형
	 * @param userNo
	 * @param movieNo
	 * @throws SQLException
	 * @throws DuplicateException
	 */
	public void putWishList(int userNo, int movieNo) throws SQLException, DuplicateException {
		wishDAO.putWishList(userNo, movieNo);
	}
}
