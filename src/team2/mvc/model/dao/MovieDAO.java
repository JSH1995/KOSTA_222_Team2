package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.MovieSub;
import team2.mvc.model.dto.Tag;

public interface MovieDAO {
	
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
	int registerMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException;
	
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
	int updateMovie(int movieNo, int genreNo, String movieName, String director, String date1)throws SQLException;
	
	/**
	 * 영화 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException 
	 * */
	int deleteMovie(int movieNo) throws SQLException;
	
	/**
	 * 배우 등록
	 * @author 이치인
	 * @param actor
	 * @throws SQLException 
	 * */
	int registerActor(Actor actor) throws SQLException;
	
	/**
	 * 배우 수정
	 * @author 이치인
	 * @param actor
	 * @throws SQLException 
	 * */
	int updateActor(Actor actor)throws SQLException;
	
	/**
	 * 배우 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException 
	 * */
	int deleteActor(int movieNo) throws SQLException;
	
	/**
	 * 태그 등록
	 * @author 이치인
	 * @param tag
	 * @throws SQLException  
	 * */
	int registerTag(Tag tag) throws SQLException;
	
	/**
	 * 태그 수정
	 * @author 이치인
	 * @param tag
	 * @throws SQLException 
	 * */
	int updateTag(Tag tag)throws SQLException;
	
	/**
	 * 태그 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException  
	 * */
	int deleteTag(int movieNo) throws SQLException;
	
	/**
	 * 영화상세정보 등록
	 * @author 이치인
	 * @param movieDetail
	 * @throws SQLException  
	 * */
	int registerMovieDetail(MovidDetail movieDetail) throws SQLException;
	
	/**
	 * 영화상세정보 수정
	 * @author 이치인
	 * @param movieDetail
	 * @throws SQLException 
	 * */
	int updateMovieDetail(MovidDetail movieDetail)throws SQLException;
	
	/**
	 * 영화상세정보 삭제
	 * @author 이치인
	 * @param movieNo
	 * @throws SQLException 
	 * */
	int deleteMovieDetail(int movieNo) throws SQLException;

    //Menuview UI 에 사용할 부수적인 메소드들
	
	/**
	 * 영화고유번호에 해당하는 영화 레코드 검색
	 * @author 이치인
	 * @param movieNo
	 * @return List<MovieSub>
	 * @throws SQLException 
	 * */
	List<MovieSub> selectByMovieNo(int movieNo) throws SQLException;
	
	/**
	 * 영화고유번호에 해당하는 태그 레코드 검색
	 * @author 이치인
	 * @param movieNo
	 * @return List<Tag>
	 * @throws SQLException 
	 * */
	List<Tag> tagListByMovieNo(int movieNo) throws SQLException;
	
	

}