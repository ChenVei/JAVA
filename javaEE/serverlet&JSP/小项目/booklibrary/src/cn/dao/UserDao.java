package cn.dao;

import java.util.List;

import cn.domain.User;

public interface UserDao {

	void add(User u);

	User find(int id);

	User find(String username, String password);

	void delete(int id);

	void update(User u);

	public List<User> getAll();
}