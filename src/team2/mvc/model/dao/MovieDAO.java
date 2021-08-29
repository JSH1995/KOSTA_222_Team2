package team2.mvc.model.dao;

import java.sql.SQLException;

import team2.mvc.model.dto.Movie;

public interface MovieDAO {
	
	/**
	 *  영화 등록
	 * */
	int registerMovie(Movie movie) throws SQLException;
	
	/**
	 *  영화 수정
	 * */
	int updateMovie(Movie movie)throws SQLException;
	
	/**
	 * 영화 삭제
	 * */
	int deleteMovie(int movieNo) throws SQLException;
	
	/**
	 *  배우 등록
	 * */
	int registerActor(Actor actor) throws SQLException;
	
	/**
	 *  배우 수정
	 * */
	int updateActor(Actor actor)throws SQLException;
	
	/**
	 * 배우 삭제
	 * */
	int deleteActor(int movieNo) throws SQLException;
	
	/**
	 *  태그 등록
	 * */
	int registerTag(Tag tag) throws SQLException;
	
	/**
	 *  태그 수정
	 * */
	int updateTag(Tag tag)throws SQLException;
	
	/**
	 * 태그 삭제
	 * */
	int deleteTag(int movieNo) throws SQLException;
	
	/**
	 *  태그 등록
	 * */
	int registerMovieDetail(MovidDetail movieDetail) throws SQLException;
	
	/**
	 *  태그 수정
	 * */
	int updateMovieDetail(MovidDetail movieDetail)throws SQLException;
	
	/**
	 * 태그 삭제
	 * */
	int deleteMovieDetail(int movieNo) throws SQLException;

	

}