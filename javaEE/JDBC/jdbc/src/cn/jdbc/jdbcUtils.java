package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.datasource.MyDataSource;

public class jdbcUtils {
	
	private static MyDataSource myDataSource = null;

	private jdbcUtils() {
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* DriverManager.registerDriver(new com.mysql.jdbc.Driver()); */
			myDataSource = new MyDataSource();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		return myDataSource.getConnection();
		/*
		 * conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
		 * "user=root&password=ROOT");
		 */
	}

	public static void free(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					myDataSource.free(conn);
				}
			}
		}
	}
}
