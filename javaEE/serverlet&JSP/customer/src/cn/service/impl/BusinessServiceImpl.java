package cn.service.impl;

import java.util.List;

import cn.dao.CustomerDao;
import cn.dao.impl.CustomerDaoImpl;
import cn.domain.Customer;
import cn.domain.PageBean;
import cn.domain.QueryInfo;
import cn.domain.QueryResult;
import cn.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	CustomerDao dao = new CustomerDaoImpl();
	
	@Override
	public void addCustomer(Customer c) {
		dao.add(c);
	}

	@Override
	public void removeCustomer(String id) {
		dao.remove(id);
	}

	@Override
	public void updateCustomer(Customer c) {
		dao.update(c);
	}

	@Override
	public Customer findCustomer(String id) {
		return dao.find(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAll();
	}

	@Override
	public PageBean pageQuery(QueryInfo qi) {
		QueryResult qr = dao.pageQuery(qi.getStartindex(), qi.getPagesize());
		PageBean pb = new PageBean();
		pb.setList(qr.getList());
		pb.setTotalrecord(qr.getTotalrecord());
		
		pb.setCurrentpage(qi.getCurrentpage());
		pb.setPagesize(qi.getPagesize());
		return pb;
	}
	
}
