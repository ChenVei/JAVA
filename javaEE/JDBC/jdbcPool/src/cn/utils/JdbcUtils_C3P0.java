package cn.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class JdbcUtils_C3P0 {
	private static ComboPooledDataSource ds = null;
	static {
		try {
			ds = new ComboPooledDataSource(); 
//			ds.setUser("root");
//			ds.setPassword("ROOT");
//			ds.setDriverClass("com.mysql.jdbc.Driver");
//			ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");
		} catch (Exception e) {
			throw new ExceptionInInitializerError("fail to load");
		}
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs = null;
		
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
