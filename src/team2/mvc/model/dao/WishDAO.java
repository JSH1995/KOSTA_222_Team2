package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;

public interface WishDAO {

	List<Movie> viewWishList(int userNo, int movieNo) throws SQLException;

	int putWishList(int userNo, int movieNo) throws SQLException;

}
