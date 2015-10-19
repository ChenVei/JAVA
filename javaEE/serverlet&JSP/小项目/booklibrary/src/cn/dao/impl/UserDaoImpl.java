package cn.dao.impl;

import java.util.List;

import cn.dao.UserDao;
import cn.domain.User;
import cn.utils.BeanHandler;
import cn.utils.BeanListHandler;
import cn.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	
	public void add(User u) {
		String sql = "insert into user(username,password,email,admin) values(?,?,?,?)";
		Object[] params = { u.getUsername(), u.getPassword(), u.getEmail(), u.isAdmin()};
		JdbcUtils.update(sql, params);
	}
	
	public List<User> getAll() {
		String sql = "select * from user";
		return (List<User>) JdbcUtils.find(sql, new Object[]{}, new BeanListHandler<User>(User.class));
	}
	
	public User find(int id) {
		String sql = "select * from user where id=?";
		Object[] params = {""+id};
		return (User) JdbcUtils.find(sql, params, new BeanHandler<User>(User.class));
	}
	
	public User find(String username, String password) {
		String sql = "select * from user where username=? and password=?";
		Object[] params = {username, password};
		return (User) JdbcUtils.find(sql, params, new BeanHandler<User>(User.class));
	}
	
	public void delete(int id) {
		String sql = "Delete from user where id=?";
		Object[] params = {""+id};
		JdbcUtils.update(sql, params);
	}
	
	public void update(User u) {
		String sql = "update user set password=?,admin=? where id=?";
		Object[] params = {u.getPassword(), u.isAdmin(), u.getId()};
		JdbcUtils.update(sql, params);
	}
}
