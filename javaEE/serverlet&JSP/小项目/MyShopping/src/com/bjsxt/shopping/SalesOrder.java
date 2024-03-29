package com.bjsxt.shopping;

import java.sql.Timestamp;
import java.util.List;

public class SalesOrder {
	int id;
	User user;
	String addr;
	Timestamp oDate;
	int status;
	
	Cart cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Timestamp getoDate() {
		return oDate;
	}

	public void setoDate(Timestamp oDate) {
		this.oDate = oDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public void save() {
		OrderMgr.getInstance().saveOrder(this);
	}
	
	public List<SalesItem> getItems() {
		return OrderMgr.getInstance().getItems(this);
	}
	
	public void updateStatus() {
		OrderMgr.getInstance().updateStatus(this);
	}
}
