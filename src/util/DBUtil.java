package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB������ ���� �ε�, ����, �ݱ� 
 * */
public class DBUtil {

	/**
	 * �ε�
	 * */
	static {
		try {
		  Class.forName(DbProperties.DRIVER_NAME); //����Ŭ������ ã�´�.!!
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DbProperties.URL, DbProperties.USER_ID, DbProperties.USER_PASS);
	}
	
	
	/**
	 * �ݱ�(select�� ���)
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
	 * �ݱ�(DML, DDL �� ���)
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








