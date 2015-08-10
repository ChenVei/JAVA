package com.bbs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.model.Category;
import com.bbs.util.DB;

public class CategoryService {
	public void add(Category c) {
		Connection conn = DB.getConn();
		String sql = "insert into _category values(null,?,?)";
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.closeStmt(pstmt);
		DB.closeConn(conn);
	}

	public List<Category> list() throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		Connection conn = DB.getConn();
		String sql = "select * from _category";
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			Category c;
			while (rs.next()) {
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				categories.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw(e);
		}
		DB.closeStmt(pstmt);
		DB.closeConn(conn);
		return categories;
	}

	public void delete(Category c) {
		deleteById(c.getId());
	}

	public void deleteById(int id) {
		Connection conn = DB.getConn();
		String sql = "delete from _category where id=" + id;
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.closeStmt(pstmt);
		DB.closeConn(conn);
	}

	public void update(Category c) {
		Connection conn = DB.getConn();
		String sql = "update _category set name=?,description=? where id=?";
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getDescription());
			pstmt.setInt(3, c.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.closeStmt(pstmt);
		DB.closeConn(conn);
	}

	public Category loadById(int id) {
		Connection conn = DB.getConn();
		String sql = "select * from _category where id=" + id;
		PreparedStatement pstmt = DB.prepare(conn, sql);
		Category c = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.closeStmt(pstmt);
		DB.closeConn(conn);
		return c;
	}
}
