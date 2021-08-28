package team2.mvc.model.service;

import java.sql.SQLException;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.dao.MovieDAO;
import team2.mvc.model.dao.MovieDAOImpl;

public class MovieService {
	
    private MovieDAO movieDAO = new MovieDAOImpl();
	
	public MovieService() {
		
	}

	public void registerMovie(Movie movie) throws SQLException {
		int result = movieDAO.registerMovie(movie);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}

	public void updateMovie(Movie movie) throws SQLException {
		int result = movieDAO.updateMovie(movie);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}

	public void deleteMovie(int movieNo) throws SQLException {
		int result = movieDAO.deleteMovie(movieNo);
		if(result == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
		
	}

}
