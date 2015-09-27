package cn.demo;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.domain.User;
import cn.utils.JdbcUtils;

public class Demo1 {
	/**
	 * CREATE TABLE `jdbc` 
	 * ( `age` int(11) NOT NULL AUTO_INCREMENT, 
	 * `birth` date DEFAULT NULL, 
	 * `name` varchar(45) NOT NULL, 
	 * `money` float NOT NULL,
	 *  PRIMARY KEY (`age`) ) 
	 * @throws SQLException 
	 */
	
	@Test
	public void insert() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into jdbc(age,birth,name,money) values(?,?,?,?)";
		Calendar c = Calendar.getInstance();
		c.set(1995, 6, 20);
		Date d = c.getTime();
		Object params[] = {20,d,"HQ",5000.00};
		qr.update(sql, params);
	}
	@Test
	public void update() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update jdbc set name=? where age=?";
		Object params[] = {"XY", 16};
		qr.update(sql, params);
	}
	@Test
	public void delete() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from jdbc where age=?";
		qr.update(sql, 20);
	}
	@Test
	public void query() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from jdbc where age=?";
		User u = qr.query(sql, new BeanHandler<>(User.class), 16);
		System.out.println(u);
	}
	@Test
	public void queryList() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from jdbc";
		List<User> list = qr.query(sql, new BeanListHandler<>(User.class));
		System.out.println(list);
	}
	@Test
	public void batch() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into jdbc(age,birth,name,money) values(?,?,?,?)";
		Object[][] params = new Object[3][5];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{4+i, new Date(), i+"ws", 1000+i};
		}
		int[] a = qr.batch(sql, params);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
}
