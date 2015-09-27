package cn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * create table jdbc 
 * ( 
 *  age int(11) primary key auto_increment, 
 *  birth date,
 *  name varchar(45), 
 *  money float 
 * )
 * 
 */
public class CRUD {

	public static void main(String[] args) {
		// Retrieve();
		Create();
		// Update();
		// Delete();
		// SQLInject();
	}

	static void SQLInject() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = jdbcUtils.getConn();
			String sql = "select age, birth, name from jdbc where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ws");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getObject("age") + "/"
						+ rs.getObject("birth") + "/" + rs.getObject("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.free(conn, pstmt, rs);
		}
	}

	static void Delete() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = jdbcUtils.getConn();
			stmt = conn.createStatement();
			String sql = "delete from jdbc where money=10000";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.free(conn, stmt, rs);
		}
	}

	static void Update() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = jdbcUtils.getConn();
			stmt = conn.createStatement();
			String sql = "update jdbc set money=money*2";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.free(conn, stmt, rs);
		}
	}

	static void Create() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = jdbcUtils.getConn();
			String sql = "insert into jdbc(age, birth, name, money) values(null, '1999.2.2', 'zy', 5000)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				System.out.println(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.free(conn, pstmt, rs);
		}
	}

	static void Retrieve() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = jdbcUtils.getConn();
			stmt = conn.createStatement();
			String sql = "select age, birth, name from jdbc";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getObject("age") + "/"
						+ rs.getObject("birth") + "/" + rs.getObject("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.free(conn, stmt, rs);
		}
	}

}
