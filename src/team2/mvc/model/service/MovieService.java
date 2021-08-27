package team2.mvc.model.service;

import java.sql.SQLException;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.dao.MovieDAO;
import team2.mvc.model.dao.MovieDAOImpl;

public class MovieService {
	
    private MovieDAO movieDAO = new MovieDAOImpl();
	
	public MovieService() {
		
	}

	public void movieInsert(Movie movie) throws SQLException {
		int result = movieDAO.movieInsert(movie);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}

	public void movieUpdate(Movie movie) throws SQLException {
		int result = movieDAO.movieUpdate(movie);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}

	public void movieDelete(Movie movie) throws SQLException {
		int result = movieDAO.movieDelete(movie);
		if(result == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
		
	}

}
