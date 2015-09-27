package cn.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.utils.JdbcUtils_C3P0;
import cn.utils.JdbcUtils_DBCP;


public class demo1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//conn = JdbcUtils_DBCP.getConnection();
			conn = JdbcUtils_C3P0.getConnection();
			
			System.out.println(conn.getClass().getName());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, pstmt, rs);
		}
	}
}
