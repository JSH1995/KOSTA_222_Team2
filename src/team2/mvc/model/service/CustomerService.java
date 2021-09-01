package team2.mvc.model.service;

import team2.mvc.model.dto.Evaluation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dao.CustomerDAO;
import team2.mvc.model.dao.CustomerDAOImpl;
import team2.mvc.model.dto.User;
import team2.mvc.util.DbUtil;

public class CustomerService {
	CustomerDAO customerDao = new CustomerDAOImpl();

	/**
	 * 회원가입 실패하면 뜨는 메소드
	 * 
	 * @throws Exception
	 * @throws NotFoundException
	 */
	public int registerUser(int userNo, String id, String password, int age, String userRegDate, int favTag,
			int favGenre) throws Exception, NotFoundException {
		int result = customerDao.registerUser(userNo, id, password, age, userRegDate, favTag, favGenre);
		if (result == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return result;
	}

	/**
	 * 로그인 실패하면 뜨는 메소드
	 * 
	 * @author 조성휘
	 * @param id
	 * @param password
	 * @throws SQLException
	 * @throws NotFoundException
	 */

	public List<User> login(String id, String password) throws SQLException, NotFoundException {
		List<User> list = customerDao.login(id, password);
		if (list.size() == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return list;
	}

	/**
	 * 사용자 평가 추가할때 실패하면 뜨는 메소드
	 * 
	 * @author 조성휘
	 * @param userNo
	 * @param movieNo
	 * @param rate
	 * @param comment
	 * @param rateDate
	 * @throws Exception
	 * @throws NotFoundException
	 */
	public int Evaluation(int userNo, int movieNo, int rate, String comment, String rateDate)
			throws Exception, NotFoundException {
		int result = customerDao.Evaluation(userNo, movieNo, rate, comment, rateDate);
		if (result == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return result;
	}

	/**
	 * 사용자 태그 등록 메소드
	 * 
	 * @author 홍전형
	 * @param movienum
	 * @param tag
	 * @throws Exception
	 */
	public void putTag(int movienum, String tag) throws Exception {
		customerDao.putTag(movienum, tag);
	}

}
