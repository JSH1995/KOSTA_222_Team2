/**
 * @author 홍전형
 *  위시리스트 기반 추천 영화 리스트를 제공하기 위해 데이터베이스와 연동하는 클래스
 */
package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import team2.mvc.model.dto.Movie;

public interface RecommendDAO {
	/**
	 * @author 홍전형
	 * 해당 나이대에 가장 많이 위시리스트에 담긴 영화를 추천
	 * @param age
	 * @return 나이 대비 추천 영화 리스트
	 * @throws SQLException
	 */
	List<Movie> recByAge(int age) throws SQLException;

	/**
	 * @author 홍전형
	 * 위시리스트에 가장 많이 담긴 영화를 추천
	 * @return 랭크순위별 영화 추천 리스트
	 * @throws SQLException
	 */
	List<Movie> recByRank() throws SQLException;

	/**
	 * @author 홍전형
	 * @param 유저 고유번호
	 * 사용자가 선호하는 장르의 영화를 추천
	 * @return 유저가 좋아하는 장르를 기반으로 리스트 리턴
	 * @throws SQLException
	 */
	List<Movie> recByGenre(int userNo) throws SQLException;

	/**
	 * @author 홍전형
	 * 위시리스트가 존재할 때 장르 기반 추천하는 영화 리스트 리턴하는 메서드
	 * @param con
	 * @param genreNo
	 * @return 유저가 선택한 좋아하는 장르 기반 추천 영화 리스트
	 * @throws SQLException
	 */
	List<Movie> recByTag(int userNo) throws SQLException;
}
