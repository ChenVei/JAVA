package com.dao.impl;

import com.dao.UserDao;
import com.model.User;

public class UserDAOImpl implements UserDao {

	public void save(User u) {
		System.out.println("UserDAOImpl...");
	}		
	public void delete(User u) {
		System.out.println("deleteUser...");
	}

}
