package cn.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClobTest {

	public static void main(String[] args) {
		read();
	}	
	static void read() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = jdbcUtils.getConn();
			String sql = "select cont from clob";
			pstmt = conn.prepareStatement(sql);
			File f = new File("CRUD_BAK.java");
			System.out.println(f.getAbsolutePath());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Clob clob = rs.getClob(1);
				Reader r = clob.getCharacterStream();
				Writer w = new BufferedWriter(new FileWriter(f));
				char[] c = new char[1024];
				int len = 0;
				while ((len = r.read(c)) > 0) {
					w.write(c, 0, len);
				}
				w.close();
				r.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.free(conn, pstmt, rs);
		}
	}
	static void create() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = jdbcUtils.getConn();
			String sql = "insert into clob(cont) values(?)";
			pstmt = conn.prepareStatement(sql);
			File f = new File("src/cn/jdbc/CRUD.java");
			System.out.println(f.getAbsolutePath());
			Reader r = new BufferedReader(new FileReader(f));
			pstmt.setCharacterStream(1, r);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.free(conn, pstmt, rs);
		}
	}
}
