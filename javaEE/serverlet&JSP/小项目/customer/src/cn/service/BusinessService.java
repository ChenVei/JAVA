package cn.service;

import java.util.List;

import cn.domain.Customer;
import cn.domain.PageBean;
import cn.domain.QueryInfo;

public interface BusinessService {
	
	void addCustomer(Customer c);
	
	void removeCustomer(String id);
	
	void updateCustomer(Customer c);
	
	Customer findCustomer(String id);
	
	List<Customer> getAllCustomer();
	
	PageBean pageQuery(QueryInfo qi);
}
