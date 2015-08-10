package com.bjsxt.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bjsxt.shopping.util.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	public static void save(Category c) {
		Connection conn = DB.getConn();
		String sql = "";
		if (c.getId() == -1) {
			sql = "insert into category values (null, ?, ?, ?, ?, ?)";
		} else
			sql = "insert into category values (" + c.getId()
					+ ", ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = DB.getPStmt(conn, sql);
		try {
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getDescr());
			pstmt.setInt(3, c.getPid());
			pstmt.setInt(4, c.isLeaf() ? 0 : 1);
			pstmt.setInt(5, c.getGrade());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public static void getCategories(List<Category> list, int id) {
		Connection conn = DB.getConn();
		getCategories(conn, list, id);
		DB.closeConn(conn);
	}
	
	private static void getCategories(Connection conn, List<Category> list, int id) {
		ResultSet rs = null;
		try {
			String sql = "select * from category where pid =" + id;
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescr(rs.getString("descr"));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("isleaf") == 0 ? true : false);
				c.setGrade(rs.getInt("grade"));
				list.add(c);
				if (!c.isLeaf()) {
					getCategories(list, c.getId());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
		}
	}

	public static void addChildCategory(int pid, String name, String descr) {
		Connection conn = DB.getConn();
		Statement stmt = DB.getStmt(conn);
		PreparedStatement pstmt = null;
		String sql = "select * from category where id=" + pid;
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			conn.setAutoCommit(false);

			rs.next();
			sql = "update category set isleaf=1 where id=" + pid;
			stmt.executeUpdate(sql);
			int Pgrade = rs.getInt("grade");

			sql = "insert into category values (null,?, ?, ?, ?, ?)";
			pstmt = DB.getPStmt(conn, sql);
			pstmt.setString(1, name);
			pstmt.setString(2, descr);
			pstmt.setInt(3, pid);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, Pgrade + 1);
			pstmt.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(stmt);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}

	public static Category loadById(int id) {
		Connection conn = null;
		ResultSet rs = null;
		Category c = null;
		try {
			conn = DB.getConn();
			String sql = "select * from category where id =" + id;
			rs = DB.executeQuery(conn, sql);
			if (rs.next()) {
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescr(rs.getString("descr"));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("isleaf") == 0 ? true : false);
				c.setGrade(rs.getInt("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return c;
	}

	public static void delete(int id, int pid) {
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from category where pid="+id;
		
		try {
			conn = DB.getConn();
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				int cid=rs.getInt("id"), cpid=rs.getInt("pid");
				delete(cid, cpid);
			}
			sql = "delete from category where id="+id;
			DB.executeUpdate(conn, sql);
			
			sql = "update category set isleaf=0 where id="+pid;
			DB.executeUpdate(conn, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
	}

	public static void modify(int id, String name, String descr) {
		Connection conn = DB.getConn();
		String sql = "update category set name='"+name+"',descr='"+descr+"' where id="+id;
		System.out.println(sql);
		
		DB.executeUpdate(conn, sql);
		DB.closeConn(conn);
	}
}








