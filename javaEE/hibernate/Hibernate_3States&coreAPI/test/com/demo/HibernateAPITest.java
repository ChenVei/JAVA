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

public class HibernateAPITest {
	private static SessionFactory sf = null;

	@BeforeClass
	public static void before() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}

	@AfterClass
	public static void after() {
		sf.close();
	}

	@Test
	public void testSave() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Person p = new Person(); // have no ID.. transient
			p.setId(9); // have no use... beacause of @generatedValue
			System.out.println(p.getId());
			p.setName("person");
			p.setTitle("personT");
			p.setDate(new Date());
			session.save(p); // have ID, in cache, in database.. persistent
								// session has a map..
			System.out.println(p.getId());

			tx.commit(); // have ID, in database.. detached
			System.out.println(p.getId());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Person p = new Person();
			p.setId(5);
			p.setName("xxxxx");
			p.setTitle("ssssT");
			p.setDate(new Date());
			session.delete(p); // ignore other info...

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoad() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Person p = (Person) session.load(Person.class, 4);
			System.out.println(p.getClass()); // when used, the SQL executed,
												// like p.getName()...
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Person p = (Person) session.get(Person.class, 4);
			System.out.println(p.getClass()); // the SQL executed directly...
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Person p = (Person) session.get(Person.class, 1);
			p.setTitle("wsws");
			Customer c = (Customer) session.get(Customer.class, 5);
			c.setUsername("user");
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdate() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Person p = new Person();
			p.setName("hq");
			p.setTitle("teacher");
			p.setDate(new Date());
			session.saveOrUpdate(p);
			tx.commit();

			Session session2 = sf.getCurrentSession();
			session2.beginTransaction();
			p.setName("lw");
			session2.saveOrUpdate(p);
			session2.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testClear() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Person p1 = (Person) session.load(Person.class, 10);
			System.out.println(p1.getName());

			session.clear(); // clear the cache...
			Person p2 = (Person) session.load(Person.class, 10);
			System.out.println(p2.getName());

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFlush() {
		try {
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Person p1 = (Person) session.load(Person.class, 10);
			p1.setName("hy");

			session.flush();
			Person p2 = (Person) session.load(Person.class, 10);
			p2.setName("xy");

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSchemaExport() {
		SchemaExport se = new SchemaExport(new Configuration().configure());
		se.create(true, false);
	}
}
