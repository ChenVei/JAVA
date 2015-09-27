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
import cn.service.SecurityService;
import cn.utils.WebUtils;

public class ResourceServlet extends HttpServlet {

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
			String privilegeid = request.getParameter("privilegeID");
			ss.updateResourcePrivilege(rid, privilegeid);
			request.setAttribute("message", "update successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to update...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void updatePrivilege(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("id");
		Resource r = ss.findResourceById(rid);

		List<Privilege> list = ss.getAllPrivilege();
		request.setAttribute("list", list);
		request.setAttribute("r", r);
		request.getRequestDispatcher("/security/updateResourcePrivilege.jsp")
				.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Resource r = WebUtils.request2Bean(request, Resource.class);
			r.setId(UUID.randomUUID().toString());
			ss.addResouce(r);
			request.setAttribute("message", "add successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to add...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/security/addresource.jsp").forward(
				request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Resource> list = ss.getAllResource();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/listresource.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
