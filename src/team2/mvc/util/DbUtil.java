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

	public static Properties getProFile() {
		return proFile;
	}
	//로드
	static {
		try {
			// 외부 ~.properties 파일 로딩
			proFile.load(new FileInputStream("src/team2/mvc/util/DBProperties.properties"));
			Class.forName(proFile.getProperty("driverName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//연결 
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"),
				proFile.getProperty("userPass"));

	}

	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			dbClose(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ݱ�(DML, DDL�� ���)
	 * 
	 * @throws SQLException
	 */
	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			Connection con = DbUtil.getConnection();
			System.out.println("���� �Ϸ� = " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
