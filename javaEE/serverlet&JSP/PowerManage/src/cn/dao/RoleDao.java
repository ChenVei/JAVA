package cn.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.Privilege;
import cn.domain.Role;
import cn.utils.JdbcUtils;

public class RoleDao {

	public void add(Role role) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into role(id,name,description) values(?,?,?)";
			Object[] params = { role.getId(), role.getName(),
					role.getDescription() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Role find(String id) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role where id=?";
			Role r = qr.query(sql, new BeanHandler<Role>(Role.class), id);

			sql = "select p.* from privilege p, role_privilege rp where rp.role_id=? and p.id=rp.privilege_id";
			List<Privilege> list = qr.query(sql,
					new BeanListHandler<Privilege>(Privilege.class), id);
			r.getPrivileges().addAll(list);
			return r;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Role> getAll() {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role";
			List<Role> list = qr.query(sql, new BeanListHandler<Role>(
					Role.class));

			for (Role r : list) {
				sql = "select p.* from privilege p, role_privilege rp where rp.role_id=? and p.id=rp.privilege_id";
				List<Privilege> list1 = qr.query(sql,
						new BeanListHandler<Privilege>(Privilege.class),
						r.getId());
				r.getPrivileges().addAll(list1);
			}

			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void updateRolePrivilegs(Role role, List<Privilege> privileges) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from role_privilege where role_id=?";
			qr.update(sql, role.getId());

			for (Privilege p : privileges) {
				sql = "insert into role_privilege(role_id, privilege_id) values(?,?)";
				Object[] params = {role.getId(), p.getId()};
				qr.update(sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
