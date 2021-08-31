package team2.mvc.model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Tag;
import team2.mvc.model.dto.User;
import team2.mvc.util.DbUtil;

public class CustomerDAOImpl implements CustomerDAO {
	

	public int registerUser(int userNo, String id, String password, int age, String userRegDate,int favTag, int favGenre) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
	    int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into 사용자 values(?,?,?,?,?,?,?)");
			ps.setInt(1, userNo);
			ps.setString(2, id);
			ps.setString(3, password);
			ps.setInt(4, age);
			ps.setString(5, userRegDate);
			ps.setInt(6, favTag);
			ps.setInt(7, favGenre);
			
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	public List<User> login(String id, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select * from 사용자 where 아이디 = ? and 비밀번호 = ?");
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
		
			
			if(rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	@Override
	public List<User> logout() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> privacyUpdate() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int Evaluation(int userNo, int movieNo, int rate, String comment,
			String rateDate) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		List<team2.mvc.model.dto.Evaluation> list = new ArrayList();
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into 사용자_평가 values(?,?,?,?,?)");
			ps.setInt(1, userNo);
			ps.setInt(2, movieNo);
			ps.setInt(3, rate);
			ps.setString(4, comment);
			ps.setString(5, rateDate);
		
			result=ps.executeUpdate();
		//	rs = ps.executeQuery();

//			if(rs.next()) {
//				list.add(new team2.mvc.model.dto.Evaluation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
//			}
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		//return list;
		return result;
	}
	@Override
	public List<User> passwordUpdate() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> passwordUpdate(String pw1, String pw2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> passwordUpdate(int user_nums, String pw1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void putTag(int userNo, int movienum) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
	
			
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
	}

}
