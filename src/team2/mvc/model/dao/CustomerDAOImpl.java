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

import oracle.jdbc.driver.DBConversion;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Tag;
import team2.mvc.model.dto.User;
import team2.mvc.util.DbUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	/**
	 * @author 조성휘
	 * 회원가입하는 메소드
	 */
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
	/**
	 * @author 조성휘
	 * 사용자가 로그인하는 메소드
	 */
	public List<User> login(String id, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select * from 사용자 where 아이디 = ? and 비밀번호 = ?");
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();		
			if(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			} else {
				throw new SQLException("잘못된 아이디 혹은 비밀번호입니다.");
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

	/**
	 * @author 조성휘
	 * 사용자가 사용자 평가를 추가하는 메소드
	 */
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
	
	/**
	 * @author 홍전형
	 * 영화에 사용자가 태그를 추가하는 메서드
	 */
	@Override
	public void putTag(int movienum, String tag) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE 영화_상세 set 사용자_태그 = ? WHERE 영화_고유번호 = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			
			String previousTag = getUserTag(con, movienum);
			
			if(previousTag == null) previousTag = "";
			
			ps.setString(1, tag + " | " + previousTag);
			ps.setInt(2, movienum);

			result = ps.executeUpdate();
			if(result == 0) {
				throw new SQLException("등록이 불가합니다.");
			}
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
	}
	/**
	 * @author 홍전형
	 * 영화에 들어가있는 사용자 태그를 가져오는 메서드
	 */
	public String getUserTag(Connection con, int movienum) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String tags = null;
		String sql = "select 사용자_태그 from 영화_상세 where 영화_고유번호 = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, movienum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				tags = rs.getString(1);
			}
		} finally {
			DbUtil.dbClose(null, ps, rs);
		}
		
		return tags;
		
		
	}

}
