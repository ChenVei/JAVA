package cn.dao;

import java.util.List;

import cn.domain.Customer;
import cn.domain.QueryResult;

public interface CustomerDao {
	void add(Customer c);
	void remove(String id);
	void update(Customer c);
	Customer find(String id);
	List<Customer> getAll();
	public QueryResult pageQuery(int startindex, int pagesize);
}
