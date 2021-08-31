package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.MovieSub;
import team2.mvc.model.dto.Tag;

public interface MovieDAO {
	
	/**
	 *  영화 등록
	 * */
	int registerMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException;
	
	/**
	 *  영화 수정
	 * */
	int updateMovie(int movieNo, int genreNo, String movieName, String director, String date1)throws SQLException;
	
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
	 *  영화상세정보 등록
	 * */
	int registerMovieDetail(MovidDetail movieDetail) throws SQLException;
	
	/**
	 *  영화상세정보 수정
	 * */
	int updateMovieDetail(MovidDetail movieDetail)throws SQLException;
	
	/**
	 * 영화상세정보 삭제
	 * */
	int deleteMovieDetail(int movieNo) throws SQLException;

	/**
	 * Menuview UI 에 사용할 부수적인 메소드들
	 *     1. 영화 고유번호에 해당하는 레코드 검색
	 * */
	
	List<MovieSub> selectByMovieNo(int movieNo) throws SQLException;
	
	

}