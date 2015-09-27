package com.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDao;
import com.dao.impl.UserDAOImpl;
import com.model.User;

public class UserService {
	private UserDao userDAO = null;
	
	public void add(User u) {
		userDAO.save(u);
	}
	
	public UserDao getUserDAO() {
		return userDAO;
	}
	
	@Resource(name="u2")
	public void setUserDAO(UserDao userDAO) {
		this.userDAO = userDAO;
	}
}
