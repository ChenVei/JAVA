package cn.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils_ {
	private static Properties config = new Properties();

	static {
		InputStream is = JdbcUtils_.class.getClassLoader().getResourceAsStream(
				"db.properties");
		try {
			config.load(is);
			Class.forName(config.getProperty("driver"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = config.getProperty("url");
		String user = config.getProperty("user");
		String password = config.getProperty("password");
		return DriverManager.getConnection(url, user, password);
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
