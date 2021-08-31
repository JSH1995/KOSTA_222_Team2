package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.MovieSub;
import team2.mvc.model.dto.Tag;
import team2.mvc.view.FailView;
import team2.mvc.model.dao.MovieDAO;
import team2.mvc.model.dao.MovieDAOImpl;

public class MovieService {
	
    private MovieDAO movieDAO = new MovieDAOImpl();

    
	/**
	 * 영화 등록
	 * @author 이치인
	 * @param movieNo
	 * @param genreNo
	 * @param movieName
	 * @param director
	 * @param date1
	 * @throws SQLException 
	 * 
	 * */
	public void registerMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException {
		int result = movieDAO.registerMovie(movieNo, genreNo, movieName, director, date1);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}
	/**
	 * 영화 수정
	 * @author 이치인
	 * @param movieNo
	 * @param genreNo
	 * @param movieName
	 * @param director
	 * @param date1
	 * @throws SQLException 
	 * */
	public void updateMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException {
		int result = movieDAO.updateMovie(movieNo, genreNo, movieName, director, date1);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}
	
	/**
	 * 영화 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException 
	 * */
	public void deleteMovie(int movieNo) throws SQLException {
		int result = movieDAO.deleteMovie(movieNo);
		if(result == 0) {
			throw new SQLException(movieNo+"번에 해당하는 영화정보가 존재하지 않습니다.");
		}
		
	}
	
	/**
	 * 배우 등록
	 * @author 이치인
	 * @param actor
	 * @throws SQLException 
	 * */
	public void registerActor(Actor actor) throws SQLException {
		int result = movieDAO.registerActor(actor);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}
	
	/**
	 * 배우 수정
	 * @author 이치인
	 * @param actor
	 * @throws SQLException 
	 * */
	public void updateActor(Actor actor) throws SQLException {
		int result = movieDAO.updateActor(actor);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}
	
	/**
	 * 배우 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException 
	 * */
	public void deleteActor(int movieNo) throws SQLException {
		int result = movieDAO.deleteActor(movieNo);
		if(result == 0) {
			throw new SQLException(movieNo+"번에 해당하는 배우리스트가 없습니다.");
		}
		
	}
	
	/**
	 * 태그 등록
	 * @author 이치인
	 * @param tag
	 * @throws SQLException  
	 * */
	public void registerTag(Tag tag) throws SQLException {
		int result = movieDAO.registerTag(tag);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}
	
	/**
	 * 태그 수정
	 * @author 이치인
	 * @param tag
	 * @throws SQLException 
	 * */
	public void updateTag(Tag tag) throws SQLException {
		int result = movieDAO.updateTag(tag);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}
	
	/**
	 * 태그 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException  
	 * */
	public void deleteTag(int movieNo) throws SQLException {
		int result = movieDAO.deleteTag(movieNo);
		if(result == 0) {
			throw new SQLException(movieNo+"번에 해당하는 레코드가 없습니다.");
		}
		
	}
	
	/**
	 * 영화상세정보 등록
	 * @author 이치인
	 * @param movieDetail
	 * @throws SQLException  
	 * */
	public void registerMovieDetail(MovidDetail movieDetail) throws SQLException {
		int result = movieDAO.registerMovieDetail(movieDetail);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		
	}
	
	/**
	 * 영화상세정보 수정
	 * @author 이치인
	 * @param movieDetail
	 * @throws SQLException 
	 * */
	public void updateMovieDetail(MovidDetail movieDetail) throws SQLException {
		int result = movieDAO.updateMovieDetail(movieDetail);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		
	}
	/**
	 * 영화상세정보 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException 
	 * */
	public void deleteMovieDetail(int movieNo) throws SQLException {
		int result = movieDAO.deleteMovieDetail(movieNo);
		if(result == 0) {
			throw new SQLException(movieNo+"번에 해당하는 상세정보 레코드가 없습니다.");
		} 
		
	}
    //Menuview UI 에 사용할 부수적인 메소드들
	
	/**
	 * 영화고유번호에 해당하는 영화 레코드 검색
	 * @author 이치인
	 * @param movieNo
	 * @return List<MovieSub>
	 * @throws SQLException 
	 * */
	public List<MovieSub> selectByMovieNo(int movieNo) throws SQLException {
		List<MovieSub> movieList = movieDAO.selectByMovieNo(movieNo);
		if(movieList.size() == 0 || movieList.isEmpty()) {
			throw new SQLException(movieNo+"번에 해당하는 레코드가 없습니다.");
		}
		return movieList;
	}
	
	/**
	 * 영화고유번호에 해당하는 태그 레코드 검색
	 * @author 이치인
	 * @param movieNo
	 * @return List<Tag>
	 * @throws SQLException 
	 * */
	public List<Tag> tagListByMovieNo(int movieNo) throws SQLException {
		List<Tag> tagList = movieDAO.tagListByMovieNo(movieNo);
		if(tagList.size() == 0 || tagList.isEmpty()) {
			throw new SQLException(movieNo+"번에 해당하는 레코드가 없습니다.");
		}
		return tagList;
	}
	

}
