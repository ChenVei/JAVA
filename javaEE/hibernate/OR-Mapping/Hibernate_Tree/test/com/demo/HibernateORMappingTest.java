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
		SchemaExport se = new SchemaExport(new Configuration().configure());
		se.create(true, true);
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}
	
	@Test
	public void testSave() {
		Org o1 = new Org();
		o1.setName("总公司");
		Org o2 = new Org();
		o2.setName("分公司1");
		Org o3 = new Org();
		o3.setName("分公司2");
		Org o4 = new Org();
		o4.setName("分公司2下1");
		Org o5 = new Org();
		o5.setName("分公司2下2");
		
		o5.setParent(o3);
		o4.setParent(o3);
		o3.setParent(o1);
		o2.setParent(o1);
		o1.getChildren().add(o2);
		o1.getChildren().add(o3);
		o3.getChildren().add(o4);
		o3.getChildren().add(o5);
		
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		s.save(o1);
		t.commit();
	}
	
	@Test
	public void testLoad() {
		testSave();
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		Org o = (Org)s.get(Org.class, 1);
		t.commit();
		print(o, 0);
	}

	private void print(Org o, int level) {
		String pre = "";
		for (int i = 0; i < level; i++) {
			pre += "	";
		}
		System.out.println(pre + o.getName());
		for(Org org:o.getChildren()) {  
			print(org, level + 1);
		}
	}
}



