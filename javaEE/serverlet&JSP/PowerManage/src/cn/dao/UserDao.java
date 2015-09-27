package cn.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.Role;
import cn.domain.User;
import cn.utils.JdbcUtils;

public class UserDao {
	
	public void add(User u) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user(id,username,password,description) values(?,?,?,?)";
			Object[] params = { u.getId(),u.getUsername(),u.getPassword(),u.getDescription()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(String id) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			User u = qr.query(sql, new BeanHandler<User>(User.class), id);
			
			if (u == null) {
				return null;
			}
			
			sql = "select r.* from user_role ur, role r where ur.user_id=? and ur.role_id=r.id ";
			List<Role> list = qr.query(sql, new BeanListHandler<Role>(Role.class), id);
			u.getRoles().addAll(list);
			return u;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(String username, String password) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object[] params = {username, password};
			User u = qr.query(sql, new BeanHandler<User>(User.class), params);
			
			if (u == null) {
				return null;
			}
			
			sql = "select r.* from user_role ur, role r where ur.user_id=? and ur.role_id=r.id ";
			List<Role> list = qr.query(sql, new BeanListHandler<Role>(Role.class), u.getId());
			u.getRoles().addAll(list);
			return u;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateUserRoles(User u, List<Role> roles) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from user_role where user_id=?";
			qr.update(sql, u.getId());
			
			for (Role r : roles) {
				sql = "insert into user_role(user_id, role_id) values(?,?) ";
				Object[] params = {u.getId(), r.getId()};
				qr.update(sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<User> getAll() {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user";
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
