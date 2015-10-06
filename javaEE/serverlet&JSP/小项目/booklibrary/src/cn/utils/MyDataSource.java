package cn.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

class MyDataSource {
	
	private static Properties config;
	private static LinkedList<Connection> connectionPool = new LinkedList<Connection>();

	private static int ini = 5;
	private static int max = 10;
	private static int curr = 0;

	static {
		try {
			InputStream is = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("db.properties");
			config = new Properties();
			config.load(is);
			String driver = config.getProperty("driver");
			Class.forName(driver);

			for (int i = 0; i < ini; i++) {
				Connection conn = createConnection();
				connectionPool.add(conn);
				curr++;
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		synchronized (connectionPool) {
			if (connectionPool.size() > 0) {
				return connectionPool.removeFirst();
			}
			if (curr < max) {
				curr++;
				return createConnection();
			}
			throw new SQLException("no more connections...");
		}
	}
	
	public static void free(Connection conn) {
		connectionPool.addLast(conn);
	}
	
	public static Connection createConnection() throws SQLException {
		String url = config.getProperty("url");
		String user = config.getProperty("user");
		String password = config.getProperty("password");

		return DriverManager.getConnection(url, user, password);
	}
}
