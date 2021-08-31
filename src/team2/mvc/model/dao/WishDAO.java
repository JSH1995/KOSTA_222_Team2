/**
 * @author 홍전형
 *  위시리스트 기반 추천 영화 리스트를 제공하기 위해 데이터베이스와 연동하는 클래스
 */

package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.exception.DuplicateException;
import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dto.Movie;

public interface WishDAO {
	/**
	 * 사용자의 위시리스트를 출력하는 메서드
	 * @author 홍전형
	 * @param userNo
	 * @return 위시리스트
	 * @throws SQLException
	 * @throws NotFoundException
	 */
	List<Movie> viewWishList(int userNo) throws SQLException, NotFoundException;

	/**
	 * 사용자의 위시리스트에 영화를 추가하는 메서드
	 * @param userNo
	 * @param movieNo
	 * @throws SQLException
	 * @throws DuplicateException
	 */
	void putWishList(int userNo, int movieNo) throws SQLException, DuplicateException;

}
