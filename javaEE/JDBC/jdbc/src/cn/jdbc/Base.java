package cn.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = jdbcUtils.getConn();
		System.out.println(conn);
		conn.close();
		conn.createStatement();
		
		for (int i = 0; i < 15; i++) {
			
			//jdbcUtils.free(conn, null, null);
		}
	}
}
