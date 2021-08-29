package team2.mvc.model.service;

import java.sql.SQLException;

import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Tag;
import team2.mvc.model.dao.MovieDAO;
import team2.mvc.model.dao.MovieDAOImpl;

public class MovieService {
	
    private MovieDAO movieDAO = new MovieDAOImpl();

    
    /**
     * 영화
     * */

	public void registerMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException {
		int result = movieDAO.registerMovie(movieNo, genreNo, movieName, director, date1);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}

	public void updateMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException {
		int result = movieDAO.updateMovie(movieNo, genreNo, movieName, director, date1);
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
	
	/**
	 * 배우 
	 * */
	
	public void registerActor(Actor actor) throws SQLException {
		int result = movieDAO.registerActor(actor);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}

	public void updateActor(Actor actor) throws SQLException {
		int result = movieDAO.updateActor(actor);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}

	public void deleteActor(int movieNo) throws SQLException {
		int result = movieDAO.deleteActor(movieNo);
		if(result == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
		
	}
	
	/**
	 * 태그
	 * */
	
	public void registerTag(Tag tag) throws SQLException {
		int result = movieDAO.registerTag(tag);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}

	public void updateTag(Tag tag) throws SQLException {
		int result = movieDAO.updateTag(tag);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}

	public void deleteTag(int movieNo) throws SQLException {
		int result = movieDAO.deleteTag(movieNo);
		if(result == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
		
	}
	
	/**
	 * 영화상세정보
	 * */
	
	public void registerMovieDetail(MovidDetail movieDetail) throws SQLException {
		int result = movieDAO.registerMovieDetail(movieDetail);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}

	public void updateMovieDetail(MovidDetail movieDetail) throws SQLException {
		int result = movieDAO.updateMovieDetail(movieDetail);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}

	public void deleteMovieDetail(int movieNo) throws SQLException {
		int result = movieDAO.deleteMovieDetail(movieNo);
		if(result == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		} 
		
	}

}
