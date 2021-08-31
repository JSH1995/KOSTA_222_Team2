package team2.mvc.model.service;

import team2.mvc.model.dto.Evaluation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import team.mvc.exception.NotFoundException;
import team2.mvc.model.dao.CustomerDAO;
import team2.mvc.model.dao.CustomerDAOImpl;
import team2.mvc.model.dto.User;
import team2.mvc.util.DbUtil;


public class CustomerService {
	CustomerDAO customerDao = new CustomerDAOImpl();
	
	public int registerUser(int userNo, String id, String password, int age, String userRegDate,int favTag,int favGenre
			) throws Exception, NotFoundException {
		int result = customerDao.registerUser(userNo,id,password,age,userRegDate,favTag,favGenre);
		if (result == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return result;
	}
	public List<User> login( String id, String password) throws SQLException, NotFoundException {
		List<User> list = customerDao.login(id,password);
		if (list.size() == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return list;
	}
	
	public int Evaluation( int userNo, int movieNo, int rate, String comment,
			String rateDate) throws Exception, NotFoundException {
		int result = customerDao.Evaluation(userNo,movieNo,rate,comment,rateDate);
		if (result == 0) {
			throw new NotFoundException("다시 시도해주세요.");
		}
		return result;
	}
	
	

}
