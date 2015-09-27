package cn.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.Privilege;
import cn.domain.Resource;
import cn.utils.JdbcUtils;

public class ResourceDao {
	
	public void add(Resource r) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into resource(id,uri,description) values(?,?,?)";
			Object[] params = {r.getId(),r.getUri(),r.getDescription()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Resource find(String uri) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from resource where uri=?";
			Resource r = qr.query(sql, new BeanHandler<Resource>(Resource.class),uri);
			
			sql = "select p.* from resource r,privilege p where r.privilege_id=p.id and uri=?";
			Privilege p = qr.query(sql, new BeanHandler<Privilege>(Privilege.class),uri);
			r.setPrivilege(p);
			return r;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public Resource findById(String id) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from resource where id=?";
			Resource r = qr.query(sql, new BeanHandler<Resource>(Resource.class),id);
			
			sql = "select p.* from resource r,privilege p where r.privilege_id=p.id and r.id=?";
			Privilege p = qr.query(sql, new BeanHandler<Privilege>(Privilege.class),id);
			r.setPrivilege(p);
			return r;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Resource> getAll() {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from resource";
			List<Resource> list = qr.query(sql, new BeanListHandler<Resource>(Resource.class));
			
			for (Resource resource : list) {
				sql = "select p.* from resource r,privilege p where r.privilege_id=p.id and r.id=?";
				Privilege p = qr.query(sql, new BeanHandler<Privilege>(Privilege.class),resource.getId());
				resource.setPrivilege(p);
			}
			
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updatePrivilege(Resource r, Privilege p	){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update resource set privilege_id=? where id=?";
			Object[] params = {p.getId(), r.getId()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
