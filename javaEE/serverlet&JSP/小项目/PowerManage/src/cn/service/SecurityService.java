package cn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.dao.PrivilegeDao;
import cn.dao.ResourceDao;
import cn.dao.RoleDao;
import cn.dao.UserDao;
import cn.domain.Privilege;
import cn.domain.Resource;
import cn.domain.Role;
import cn.domain.User;

public class SecurityService {

	private ResourceDao rdao = new ResourceDao();
	private PrivilegeDao pdao = new PrivilegeDao();
	private RoleDao roledao = new RoleDao();
	private UserDao udao = new UserDao();
	
	/******************************************************************************
	 * provide resource relational service
	 ********************************************************************************/
	public void addResouce(Resource r) {
		rdao.add(r);
	}

	public Resource findResource(String uri) {
		return rdao.find(uri);
	}

	public Resource findResourceById(String id) {
		return rdao.findById(id);
	}

	public List<Resource> getAllResource() {
		return rdao.getAll();
	}

	public void updateResourcePrivilege(String sourceid, String privilegeid) {
		Resource r = rdao.findById(sourceid);
		Privilege p = pdao.find(privilegeid);
		rdao.updatePrivilege(r, p);
	}
	/******************************************************************************
	 * provide privilege relational service
	 ********************************************************************************/
	public void addPrivilege(Privilege p) {
		pdao.add(p);
	}

	public Privilege findPrivilege(String id) {
		return pdao.find(id);
	}

	public List<Privilege> getAllPrivilege() {
		return pdao.getAll();
	}
	
	/******************************************************************************
	 * provide role relational service
	 ********************************************************************************/
	public void addRole(Role r) {
		roledao.add(r);
	}

	public List<Role> getAll() {
		return roledao.getAll();
	}
	
	public Role findRole(String id) {
		return roledao.find(id);
	}
	
	public void updateRolePrivilege(String roleid, String[] privilege_ids) {
		Role role = roledao.find(roleid);
		List<Privilege> list = new ArrayList<Privilege>();
		for (int i = 0; privilege_ids != null && i < privilege_ids.length; i++) {
			list.add(pdao.find(privilege_ids[i]));
		}
		roledao.updateRolePrivilegs(role, list);
	}

	/******************************************************************************
	 * provide user relational service
	 ********************************************************************************/
	public void addUser(User u) {
		udao.add(u);
	}

	public User findUser(String id) {
		return udao.find(id);
	}

	public User find(String username, String password) {
		return udao.find(username, password);
	}

	public List<User> getAllUser() {
		return udao.getAll();
	}

	public void updateUserRole(String userid, String[] roleids) {
		User u = udao.find(userid);
		List<Role> list = new ArrayList<Role>();
		for (int i = 0; roleids != null && i < roleids.length; i++) {
			list.add(roledao.find(roleids[i]));
		}
		udao.updateUserRoles(u, list);
	}

	public List<Privilege> getUserAllPrivileges(String userid) {
		User u = udao.find(userid);
		List<Privilege> list = new ArrayList<Privilege>();
		Set<Role> setr = u.getRoles();
		for (Role role : setr) {
			Set<Privilege> setp = role.getPrivileges();
			list.addAll(setp);
		}
		return list;
	}
}
