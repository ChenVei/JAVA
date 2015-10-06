package cn.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import cn.exception.DaoException;

public class JdbcUtils {
	private static Properties config = new Properties();

	static {
		InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream(
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
	
	public static void update(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 1; i <= params.length; i++) {
				pstmt.setObject(i, params[i-1]);
			}
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}
	
	public static Object find(String sql, Object[] params, ResuletSetHandler rsh) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 1; i <= params.length; i++) {
				pstmt.setObject(i, params[i-1]);
			}
			
			rs = pstmt.executeQuery();
			return rsh.handler(rs);
			
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}
}

interface ResuletSetHandler {
	Object handler(ResultSet rs);
}
class BeanHandler implements ResuletSetHandler {
	
	Class clazz = null;
	
	public BeanHandler(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handler(ResultSet rs) {
		try {
			if (!rs.next()) {
				return null;
			}
			Object bean = clazz.newInstance();
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			
			for (int i = 1; i <= count; i++) {
				String name = meta.getColumnName(i);
				Object value = rs.getObject(name);
						
				Field f = clazz.getDeclaredField(name);
				f.setAccessible(true);
				f.set(bean, value);
			}
			
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}