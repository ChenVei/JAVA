package cn.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils {
	private static DataSource ds = null;
	static {
		try {
			Properties p = new Properties();
			InputStream is = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			p.load(is);
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
}
