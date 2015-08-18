
import com.model.Customer;


public class CustomerTest {

	public static void main(String[] args) {
			
            Session session = new Session();
             
            Customer customer = new Customer();
                customer.setId(5);
                customer.setUsername("cus to mer");
                customer.setPassword("cust omer");
                session.save(customer);


	}

}
