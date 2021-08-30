package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team.mvc.exception.NotFoundException;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dao.RecommendDAO;
import team2.mvc.model.dao.RecommendDAOImpl;

public class RecommendService {
	RecommendDAO recommendDao = new RecommendDAOImpl();

	/**
	 * 해당 나이대에 가장 많이 위시리스트에 담긴 영화를 추천
	 * 
	 * @param age
	 * @throws NotFoundException
	 */
	public List<Movie> recByAge(int age) throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByAge(age);
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}

	public List<Movie> recByRank() throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByRank();
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}

	public List<Movie> recByGenre(int userNo) throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByGenre(userNo);
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}

	public List<Movie> recByTag(int userNo) throws SQLException, NotFoundException {
		List<Movie> list = recommendDao.recByTag(userNo);
		if (list.size() == 0) {
			throw new NotFoundException("해당하는 영화가 없습니다.");
		}
		return list;
	}
}
