package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.User;

public interface CustomerDAO {
	
	List<User> registerUser(int userNo, String id, String password, int age, String userRegDate, int favGenre, int favTag) throws SQLException;
	
	List<User> login(String id, String password) throws SQLException;
	
	List<User> logout() throws SQLException;
	
	List<User> privacyUpdate() throws SQLException;
	
	List<User> passwordUpdate() throws SQLException;

	
	

	

}
