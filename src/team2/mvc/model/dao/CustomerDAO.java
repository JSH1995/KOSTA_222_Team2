package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.User;

public interface CustomerDAO {
	/**
	 * 회원 가입 메소드
	 * @throws Exception
	 */
	int registerUser(int userNo, String id, String password, int age, String userRegDate, int favTag, int favGenre) throws Exception;
	/**
	 * 로그인 메소드
	 * @param id
	 * @param password
	 * @throws SQLException
	 */
	List<User> login(String id, String password) throws SQLException;
	
	List<User> logout() throws SQLException;
	
	List<User> privacyUpdate() throws SQLException;
	
	List<User> passwordUpdate() throws SQLException;
	
	/**
	 * 사용자 평가 입력 메소드
	 * @param userNo
	 * @param movieNo
	 * @param rate
	 * @param comment
	 * @param rateDate
	 * @throws Exception
	 */
	int Evaluation(int userNo, int movieNo, int rate, String comment, String rateDate) throws Exception;

	/**
	 * 비밀번호 변경 메소드
	 * @param user_nums
	 * @param pw1
	 * @throws SQLException
	 */
	List<User> passwordUpdate(int user_nums, String pw1) throws SQLException;

	/**
	 * 사용자 태그 메소드
	 * @param movienum
	 * @param tag
	 * @throws Exception
	 */
	void putTag(int movienum, String tag) throws Exception;

	

	
	

	

}
