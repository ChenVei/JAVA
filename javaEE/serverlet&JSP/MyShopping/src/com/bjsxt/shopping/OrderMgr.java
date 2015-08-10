package com.bjsxt.shopping;

import java.util.List;

import com.bjsxt.shopping.dao.OrderMYSQLDAO;

public class OrderMgr {
	private static OrderMgr om = null;
	private OrderMYSQLDAO dao = null;
	
	private OrderMgr() {}
	static {
		if (om == null) {
			om = new OrderMgr();
			om.setDao(new OrderMYSQLDAO());
		}
	}
	
	public OrderMYSQLDAO getDao() {
		return dao;
	}
	public void setDao(OrderMYSQLDAO dao) {
		this.dao = dao;
	}
	
	public static OrderMgr getInstance() {
		return om;
	}
	public void saveOrder(SalesOrder so) {
		dao.saveOrder(so);
	}
	
	public int getOrders(List<SalesOrder> orders, int pageNo, int pageSize) {
		return dao.getOrders(orders, pageNo, pageSize);
	}
	
	public SalesOrder loadById(int id) {
		return dao.loadById(id);
	}
	public List<SalesItem> getItems(SalesOrder salesOrder) {
		return dao.getItems(salesOrder);
	}
	
	public void updateStatus(SalesOrder salesOrder) {
		dao.updateStatus(salesOrder);
	}
	
	
}



