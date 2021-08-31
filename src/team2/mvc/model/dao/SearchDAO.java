
/**
 * @author 김찬원
 * 
 */

package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Search;

public interface SearchDAO {
	
	
	/**
	 * 영화 전체 검색 및 정렬 진행
	 * @param sortType
	 * @return
	 * @throws SQLException
	 */
	
	List<Search> searchAll(String sortType) throws SQLException;
	
	/**
	 * 작품명을 토대로 검색 및 정렬 진행
	 * @param movieName
	 * @param sortType
	 * @return
	 * @throws SQLException
	 */
	
	List<Search> searchByName(String movieName, String sortType) throws SQLException;
	
	/**
	 * 감독명을 토대로 검색 및 정렬 진행
	 * @param director
	 * @param sortType
	 * @return
	 * @throws SQLException
	 */
	
	List<Search> searchByDirector(String director, String sortType) throws SQLException;
	
	/**
	 * 배우명을 토대로 검색 및 정렬 진행
	 * 배우명은 주연 및 조연에서 검색을 진행합니다.
	 * @param actor
	 * @param sortType
	 * @return
	 * @throws SQLException
	 */
	
	List<Search> searchByActor(String actor, String sortType) throws SQLException;
	
	
	/**
	 * 장르를 토대로 검색 및 정렬 진행
	 * @param genre
	 * @param sortType
	 * @return
	 * @throws SQLException
	 */
	
	List<Search> searchByGenre(String genre, String sortType) throws SQLException;
	
	/**
	 * 국가별로 검색 및 정렬 진행
	 * @param nation
	 * @param sortType
	 * @return
	 * @throws SQLException
	 */
	
	List<Search> searchByNation(String nation, String sortType) throws SQLException;
	
	
	//////////////////////////////////////////////////
	
	
	/**
	 * 영화 고유번호를 통해 영화 정보를 불러오는 메소드
	 * @param movieNo
	 * @return
	 * @throws SQLException
	 */
	
	Movie searchByPK(int movieNo) throws SQLException;
	
	/**
	 * 특정 영화에 대해 상세 정보 검색 및 출력
	 * @param movieName
	 * @return
	 * @throws SQLException
	 */
	
	Search showMovieDetail(String movieName) throws SQLException;
	
	/**
	 * 특정 영화에 대한 개인 평점 / 평가 날짜 / 코멘트 출력
	 * @param movieName
	 * @return
	 * @throws SQLException
	 */
	
	List<Evaluation> showComment(String movieName) throws SQLException;

}
