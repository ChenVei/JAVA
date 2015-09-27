package cn.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource {
	
	private static String url = "jdbc:mysql://localhost/mydata";
	private static String user = "root";
	private static String password = "ROOT";
	
	private int ini = 5;
	private int max = 10;
	private int curr = 0;
	
	private LinkedList<Connection> connectionPool = new LinkedList<>();
	
	public MyDataSource() {
		for (int i = 0; i < ini; i++) {
			connectionPool.addLast(createConnection());
			curr++;
		}
	}
	
	public void free(Connection conn) {
		connectionPool.addLast(conn);
	}
	
	public Connection getConnection() throws SQLException {
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
	
	public Connection createConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
}
