package cn.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBMetaData {

	public static void main(String[] args) {
		try {
			Connection conn = jdbcUtils.getConn();
			DatabaseMetaData dm = conn.getMetaData();
			System.out.println(dm.getDatabaseProductName());
			System.out.println(dm.supportsTransactions());
			
			PreparedStatement ps = conn.prepareStatement("select * from jdbc");
			ResultSetMetaData rsm = ps.getMetaData();
			for (int i = 0; i < rsm.getColumnCount(); i++) {
				System.out.println(rsm.getColumnName(i+1));
			}
			
			ParameterMetaData pm = ps.getParameterMetaData();
			System.out.println(pm.getParameterCount());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
