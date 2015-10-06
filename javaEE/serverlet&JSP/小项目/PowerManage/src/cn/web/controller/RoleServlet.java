package cn.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.domain.Resource;
import cn.domain.Role;
import cn.service.SecurityService;
import cn.utils.WebUtils;

public class RoleServlet extends HttpServlet {
	private SecurityService ss = new SecurityService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("getAll".equals(method)) {
			getAll(request, response);
		} else if ("addUI".equals(method)) {
			addUI(request, response);
		} else if ("add".equals(method)) {
			add(request, response);
		} else if ("updatePrivilege".equals(method)) {
			updatePrivilege(request, response);
		} else if ("updateP".equals(method)) {
			updateP(request, response);
		}
	}

	private void updateP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String rid = request.getParameter("id");
			String pids[] = request.getParameterValues("privilegeID");
			ss.updateRolePrivilege(rid, pids);
			request.setAttribute("message", "update successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to update...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	private void updatePrivilege(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("id");
		Role r = ss.findRole(rid);
		List<Privilege> list = ss.getAllPrivilege();
		request.setAttribute("list", list);
		request.setAttribute("r", r);
		request.getRequestDispatcher("/security/updateRolePrivilege.jsp")
				.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Role r = WebUtils.request2Bean(request, Role.class);
			r.setId(UUID.randomUUID().toString());
			ss.addRole(r);
			request.setAttribute("message", "add successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to add...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/security/addrole.jsp").forward(request,
				response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Role> list = ss.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/listrole.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
