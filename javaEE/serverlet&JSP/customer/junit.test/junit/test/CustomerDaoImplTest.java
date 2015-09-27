package junit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.dao.impl.CustomerDaoImpl;
import cn.domain.Customer;

public class CustomerDaoImplTest {

	@Test
	public void testAdd() {
		CustomerDaoImpl s = new CustomerDaoImpl();
		for (int i = 0; i < 250; i++) {
			Customer c = new Customer(60+i+"", "Ws", "male", new Date(), "123456789", "ss@ss.xom", "play xxx", "°¡¹þ°¡¹þ", "handsome"	);	
			s.add(c);
		}
		
	}

	@Test
	public void testRemove() {
		CustomerDaoImpl s = new CustomerDaoImpl();
		s.remove("5");
	}

	@Test
	public void testUpdate() {
		CustomerDaoImpl s = new CustomerDaoImpl();
		Customer c = s.find("1");
		c.setName("hy");
		s.update(c);
	}

	@Test
	public void testFind() {
		CustomerDaoImpl s = new CustomerDaoImpl();
		System.out.println(s.find("4"));
	}

	@Test
	public void testGetAll() {
		CustomerDaoImpl s = new CustomerDaoImpl();
		List<Customer> list = s.getAll();
		for (Customer c : list) {
			System.out.println(c);
		}
	}

}
