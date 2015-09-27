package cn.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class JdbcUtils_DBCP {
	private static Properties config = new Properties();
	private static DataSource ds = null;
	static {
		InputStream is = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream(
				"dbcpconfig.properties");
		try {
			config.load(is);
			ds = BasicDataSourceFactory.createDataSource(config);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
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
