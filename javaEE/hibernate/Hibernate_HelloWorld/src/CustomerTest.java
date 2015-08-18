import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.demo.Customer;


public class CustomerTest {

	public static void main(String[] args) {
		try {
			/*Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();*/
			
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
            /* for hibernate3.x:
             * SessionFactory sf =
             * 				       new Configuration().configure().buildSessionFactory();
            */
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            
                Customer customer = new Customer();
                customer.setUsername("customerU" );
                customer.setPassword("customerP");
                session.save(customer);
            

            tx.commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
	}

}
