package com.demo;

import java.sql.Connection;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateORMappingTest {
	private static SessionFactory sf = null;

	//@BeforeClass
	public static void before() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}

	//@AfterClass
	public static void after() {
		sf.close();
	}

	@Test
	public void testSchemaExport() {
		try {
			SchemaExport se = new SchemaExport(new Configuration().configure());
			se.create(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
