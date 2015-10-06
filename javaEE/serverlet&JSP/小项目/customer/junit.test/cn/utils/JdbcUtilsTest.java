package cn.utils;


import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import cn.domain.Customer;

public class JdbcUtilsTest {

	@Test
	public void testUpdate() {
		String sql = null;
		//sql = "insert into customer(id, name, gender) values(?, ?, ?)";
		//Object[] params = {"-1", "HQ", "girl"};
		
		//sql = "delete from customer where id = ?";
		//Object[] params = {"-1"};
		
		Calendar c = Calendar.getInstance();
		c.set(1995, 3, 10); //actual month 3+1, from 0 
		Date d = new Date(c.getTimeInMillis());
		sql = "update customer set name=?,birthday=? where id = ?";
		Object[] params = {"HY", d, "1"};

		JdbcUtils.update(sql, params);
	}
	
	@Test
	public void testFind() {
		String sql = "select * from customer where id = ?";
		Object[] params = {"1"};
		Object bean = JdbcUtils.find(sql, params, new BeanHandler(Customer.class));
		System.out.println(bean);
	}
}
