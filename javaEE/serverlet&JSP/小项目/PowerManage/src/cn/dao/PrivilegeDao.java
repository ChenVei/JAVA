package cn.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.Privilege;
import cn.utils.JdbcUtils;

public class PrivilegeDao {
	
	public void add(Privilege p) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into privilege(id,name,description) values(?,?,?)";
			Object[] params = {p.getId(),p.getName(),p.getDescription()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Privilege find(String id) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege where id=?";
			Privilege p = qr.query(sql, new BeanHandler<Privilege>(Privilege.class), id);
			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Privilege> getAll() {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege";
			List<Privilege> list = qr.query(sql, new BeanListHandler<Privilege>(Privilege.class));
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
