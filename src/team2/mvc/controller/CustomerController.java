package team2.mvc.controller;

import java.sql.Array;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.model.dto.User;
import team2.mvc.model.service.CustomerService;
import team2.mvc.util.DbUtil;
import team2.mvc.view.FailView;
import team2.mvc.view.SuccessView;
import team2.mvc.model.dto.Evaluation;


public class CustomerController {
	
	static CustomerService customerService =  new CustomerService();
	
	public static void registerUser(int userNo, String id, String password, int age, String userRegDate,int favTag, int favGenre ) {
		try {
			customerService.registerUser(userNo,id,password,age,userRegDate,favTag,favGenre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	/**
	 * 로그인 성공 여부를 판별하는 메서드
	 * @param id
	 * @param password
	 * @return
	 */
	public static boolean loginCheck(String id, String password) {
		try {
			List<User> list = customerService.login(id,password);
			System.out.println("로그인 성공! " + id + "님, 어서오세요!");
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	/**
	 * 로그인한 사용자의 정보를 가져오는 메서드
	 * @param id
	 * @param password
	 * @return
	 */
	public static List<User> login(String id, String password) {
		List<User> list = new ArrayList<>();
		try {
			System.out.println("로그인 중...");
			list = customerService.login(id,password);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return list;
	}
	
	
	public static void Evaluation(int userNo, int movieNo, int rate, String comment, String rateDate) {
		try {
			customerService.Evaluation(userNo, movieNo, rate, comment,rateDate);
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

	public static void putTag(int userNo, int movienum) {
		try {
			customerService.putTag(userNo, movienum);
			SuccessView.messagePrint("등록되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
}
