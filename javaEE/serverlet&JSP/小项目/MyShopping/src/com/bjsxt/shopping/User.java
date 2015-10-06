package com.bjsxt.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.shopping.util.DB;

public class User {
 	private int id;
 	private String username;
 	private String password;
 	private String phone;
 	private String addr;
 	private Timestamp rdate;
 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	
	public void save() {
		Connection conn = DB.getConn();
		Statement stmt = DB.getStmt(conn);
		String sql = "insert into ruser values (null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = DB.getPStmt(conn, sql);
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, phone);
			pstmt.setString(4, addr);
			pstmt.setTimestamp(5, rdate);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DB.closeStmt(pstmt);
		DB.closeConn(conn);
	}
	
	public static List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			String sql = "select * from ruser";
			rs = DB.executeQuery(conn, sql);
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}

		return list;
	}
	
	public static void deleteUser(int id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DB.getConn();
			stmt = DB.getStmt(conn);
			stmt.executeUpdate("delete from ruser where id="+id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
	}
	
	public static boolean userExists(String username) {
		boolean UEx = false;
		Connection conn = DB.getConn();
		Statement stmt = DB.getStmt(conn);
		String sql = "select * from ruser where username like '" + username + "'";
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs != null) 
			UEx = true;
		DB.closeRs(rs);
		DB.closeStmt(stmt);
		DB.closeConn(conn);
		return UEx;
	}
	
	public static boolean isPasswordCorrect(String username, String password) {
		boolean PCorr = false;
		Connection conn = DB.getConn();
		Statement stmt = DB.getStmt(conn);
		String sql = "select * from ruser where username like '" + username + "' and password like '" + password + "'";
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			if (rs.next()) 
				PCorr = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return PCorr;
	}
	
	public static User validate(String username, String password) throws UserNotFoundException, PasswordNotCorrectException {
		Connection conn = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = DB.getConn();
			String sql = "select * from ruser where username like '" + username + "'";
			rs = DB.executeQuery(conn, sql);
			if (!rs.next()) {
				throw new UserNotFoundException();
			} else if (!rs.getString("password").equals(password)) {
				throw new PasswordNotCorrectException();
			} else {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public void update() {
		Connection conn = DB.getConn();
		String sql = "update ruser set username=?,phone=?,addr=? where id=?";
		PreparedStatement pstmt = DB.getPStmt(conn, sql);
		try {
			pstmt.setString(1, getUsername());
			pstmt.setString(2, getPhone());
			pstmt.setString(3, getAddr());
			pstmt.setInt(4, getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
}







