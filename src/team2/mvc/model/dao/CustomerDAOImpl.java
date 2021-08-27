package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import team2.mvc.model.dto.User;
import team2.mvc.util.DbUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	
	
	public List<User> registerUser(int userNo, String id, String password, int age, String userRegDate) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("sql");
			ps.setInt(1, userNo);
			ps.setString(2, id);
			ps.setString(3, password);
			ps.setInt(4, age);
			ps.setString(5, userRegDate);
		
			
			if(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	public List<User> login(String id, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("sql");
			ps.setString(1, id);
			ps.setString(2, password);
		
			
			if(rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public List<User> registerUser() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> login() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<User> passwordUpdate() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
