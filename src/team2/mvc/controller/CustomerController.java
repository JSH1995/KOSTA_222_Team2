package team2.mvc.controller;

import java.sql.Array;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.User;
import team2.mvc.model.service.CustomerService;
import team2.mvc.view.FailView;

public class CustomerController {
	static CustomerService customerService =  new CustomerService();
	
	public static void registerUser(int userNo, String id, String password, int age, String userRegDate,int favTag, int favGenre ) {
		try {
			List<User> list = customerService.registerUser(userNo,id,password,age,userRegDate,favTag,favGenre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void login(String id, String password) {
		try {
			List<User> list = customerService.login(id,password);
			System.out.println("로그인 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
}
