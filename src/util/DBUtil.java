package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB연동을 위한 로드, 연결, 닫기 
 * */
public class DBUtil {

	/**
	 * 로드
	 * */
	static {
		try {
		  Class.forName(DbProperties.DRIVER_NAME); //오라클드라버를 찾는다.!!
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DbProperties.URL, DbProperties.USER_ID, DbProperties.USER_PASS);
	}
	
	
	/**
	 * 닫기(select인 경우)
	 * */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
		  if(rs!=null)rs.close();
		  dbClose(con, st);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기(DML, DDL 인 경우)
	 * */
	public static void dbClose(Connection con, Statement st) {
		try {
		  if(st!=null) st.close();
		  if(con!=null) con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}








