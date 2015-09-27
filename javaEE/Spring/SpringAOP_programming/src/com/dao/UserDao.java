package com.dao;

import com.model.User;

public interface UserDao {
	public void save(User u);
	public void delete(User u);
}
