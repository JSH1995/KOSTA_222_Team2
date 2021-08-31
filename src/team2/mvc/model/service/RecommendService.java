/**
 * @author 홍전형
 *  위시리스트 기반 추천 영화 리스트를 제공하는 Service 클래스
 */
package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dao.RecommendDAO;
import team2.mvc.model.dao.RecommendDAOImpl;

public class RecommendService {
	RecommendDAO recommendDao = new RecommendDAOImpl();

	/**
	 * 해당 나이대에 가장 많이 위시리스트에 담긴 영화를 추천
	 * @author 홍전형
	 * @param age
	 * @return 나이 대비 추천 영화 리스트
	 * @throws NotFoundException
	 */
	public List<Movie> recByAge(int age) throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByAge(age);
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}

	/**
	 * 위시리스트에 가장 많이 담긴 영화를 추천
	 * @author 홍전형
	 * @return 랭크순위별 영화 추천 리스트
	 * @throws SQLException
	 * @throws NotFoundException
	 */
	public List<Movie> recByRank() throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByRank();
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}

	/**
	 * 사용자가 선호하는 장르의 영화를 추천
	 * @author 홍전형
	 * @param userNo
	 * @return 유저가 좋아하는 장르를 기반으로 리스트 리턴
	 * @throws SQLException
	 * @throws NotFoundException
	 */
	public List<Movie> recByGenre(int userNo) throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByGenre(userNo);
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}

	/**
	 * @author 홍전형
	 * 위시리스트가 존재할 때 장르 기반 추천하는 영화 리스트 리턴하는 메서드
	 * @param con
	 * @param genreNo
	 * @return 유저가 선택한 좋아하는 장르 기반 추천 영화 리스트
	 * @throws SQLException
	 */
	public List<Movie> recByTag(int userNo) throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByTag(userNo);
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}
}
