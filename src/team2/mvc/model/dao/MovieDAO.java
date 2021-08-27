package team2.mvc.model.dao;

import java.sql.SQLException;

import team2.mvc.model.dto.Movie;

public interface MovieDAO {
	
	/**
	 *  영화 등록
	 * */
	int movieInsert(Movie movie) throws SQLException;
	
	/**
	 *  영화 수정
	 * */
	int movieUpdate(Movie movie) throws SQLException;
	
	/**
	 * 영화 삭제
	 * */
	int movieDelete(Movie movie) throws SQLException;

}
