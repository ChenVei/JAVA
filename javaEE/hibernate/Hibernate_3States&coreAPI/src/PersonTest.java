import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.demo.Person;


public class PersonTest {

	public static void main(String[] args) {
		try {
			
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            for (int i = 10; i < 20; i++) {
            	Person p = new Person();
            	p.setId(i);
            	p.setName("person"+i);
            	p.setTitle("personT"+i);
                session.save(p);
            }

            tx.commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
	}

}
