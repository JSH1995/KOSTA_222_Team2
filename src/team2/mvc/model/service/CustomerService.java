package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team.mvc.exception.NotFoundException;
import team2.mvc.model.dao.CustomerDAO;
import team2.mvc.model.dao.CustomerDAOImpl;
import team2.mvc.model.dto.User;


public class CustomerService {
	CustomerDAO customerDao = new CustomerDAOImpl();
	
	public List<User> registerUser(int userNo, String id, String password, int age, String userRegDate,String[] favGenre,
			String[] favTag) throws SQLException, NotFoundException {
		List<User> list = customerDao.registerUser(userNo,id,password,age,userRegDate,favGenre,favTag);
		if (list.size() == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return list;
	}
	public List<User> login( String id, String password) throws SQLException, NotFoundException {
		List<User> list = customerDao.login(id,password);
		if (list.size() == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return list;
	}


}
