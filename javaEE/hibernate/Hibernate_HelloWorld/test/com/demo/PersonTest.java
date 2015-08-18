package com.demo;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest {
	private static SessionFactory sf = null;
	@BeforeClass
	public static void before() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = configuration
				.buildSessionFactory(serviceRegistry);
	}
	@AfterClass
	public static void after() {
		sf.close();
	}
	
	
	@Test
	public void test() {
		try {
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			Person p = new Person();
			p.setName("person");
			p.setTitle("personT");
			p.setDate(new Date());
			session.save(p);

			tx.commit();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
