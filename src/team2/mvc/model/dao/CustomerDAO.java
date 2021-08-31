package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.User;

public interface CustomerDAO {
	
	int registerUser(int userNo, String id, String password, int age, String userRegDate, int favTag, int favGenre) throws Exception;
	
	List<User> login(String id, String password) throws SQLException;
	
	List<User> logout() throws SQLException;
	
	List<User> privacyUpdate() throws SQLException;
	
	List<User> passwordUpdate() throws SQLException;
	
	int Evaluation(int userNo, int movieNo, int rate, String comment, String rateDate) throws Exception;

	List<User> passwordUpdate(String pw1, String pw2) throws SQLException;

	List<User> passwordUpdate(int user_nums, String pw1) throws SQLException;

	void putTag(int movienum, String tag) throws Exception;

	

	
	

	

}
