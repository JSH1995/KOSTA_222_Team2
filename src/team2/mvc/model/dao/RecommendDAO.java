/**
 * @author 홍전형
 *  위시리스트 기반 추천 영화 리스트를 제공하기 위해 데이터베이스와 연동하는 클래스
 */
package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import team2.mvc.model.dto.Movie;

public interface RecommendDAO {
	List<Movie> recByAge(int age) throws SQLException;

	List<Movie> recByRank() throws SQLException;

	List<Movie> recByGenre(int userNo) throws SQLException;

	List<Movie> recByTag(int userNo) throws SQLException;
}
