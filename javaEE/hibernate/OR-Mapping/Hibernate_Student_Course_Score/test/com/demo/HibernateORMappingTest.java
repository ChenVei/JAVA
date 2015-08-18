package com.demo;

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

	@BeforeClass
	public static void before() {
		//create the table manually. hibernate can't help you...
		
		//SchemaExport se = new SchemaExport(new Configuration().configure());
		//se.create(true, true);
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}
	
	@Test
	public void testSave() {
		Student stu = new Student();
		stu.setName("ws");
		Course c = new Course();
		c.setName("java");
		Score score = new Score();
		score.setScore(90);
		score.setStudent(stu);
		score.setCouse(c);
		
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		s.save(stu);
		s.save(c);
		s.save(score);
		t.commit();
	}
	
	@Test
	public void testLoad() {
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		Student stu = (Student) s.load(Student.class, 3);
		for(Course c:stu.getCourses()) {
			System.out.println(c.getName());
		}
		t.commit();
		
	}
}



