package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import team2.mvc.model.dto.Movie;

public interface RecommendDAO {
	List<Movie> recByAge(int age) throws SQLException;

	List<Movie> recByRank() throws SQLException;

	List<Movie> recByGenre(int userNo, int genreNo) throws SQLException;

	List<Movie> recByTag(int userNo, int genreNo) throws SQLException;
}
