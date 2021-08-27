package team2.mvc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
	
	private static Properties proFile = new Properties();
	
	/**
	 * 로드
	 */

	
	static {
		try {
			//외부 ~.properties 파일 2개 로드
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			proFile.load(new FileInputStream("resources/board.properties"));
			
			//드라이버 로드
			Class.forName(proFile.getProperty("driverName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Properties getProFile() {
		return proFile;
		
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"), proFile.getProperty("userPass"));
		
	}
	
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		
		try {
			if(rs != null)
				rs.close();
			dbClose(con, st);
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	/**
	 * 닫기(DML, DDL인 경우)
	 * @throws SQLException 
	 */
	
	public static void dbClose(Connection con, Statement st) {
		
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
		
	public static void main(String[] args) {
		
		try {
			Connection con = DbUtil.getConnection();
			System.out.println("연결 완료 = " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}


