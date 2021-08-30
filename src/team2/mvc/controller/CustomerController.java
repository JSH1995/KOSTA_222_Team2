package team2.mvc.controller;

import java.sql.Array;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import team2.mvc.model.dto.User;
import team2.mvc.model.service.CustomerService;
import team2.mvc.util.DbUtil;
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
	
	public static boolean login(String id, String password) {
		try {
			List<User> list = customerService.login(id,password);
			System.out.println("로그인 성공");
			//su=true;
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
		return false;
		
	}
	
	
	public static void Evaluation(int userNo, int movieNo, int rate, String comment, String rateDate) {
		try {
			List<team2.mvc.model.dto.Evaluation> list = customerService.Evaluation(userNo, movieNo, rate, comment,rateDate);
			System.out.println("완료 되었습니다");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void update_pw(int user_nums, String pw1) {
		Connection con= null;
		Statement st=null;
		ResultSet rs= null;
		
		try {
		con = DbUtil.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("update 사용자 set 비밀번호 ='"+pw1+"' where 사용자_고유번호 = '"+user_nums+"'");
		System.out.println("성공적으로 변경 되었습니다");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, st, rs);
		}
	}
	
}
