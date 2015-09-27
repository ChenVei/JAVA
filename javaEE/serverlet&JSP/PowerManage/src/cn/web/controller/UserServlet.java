package cn.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.domain.Role;
import cn.domain.User;
import cn.service.SecurityService;
import cn.utils.WebUtils;

public class UserServlet extends HttpServlet {
	
	SecurityService ss = new SecurityService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("getAll".equals(method)) {
			getAll(request, response);
		} else if ("addUI".equals(method)) {
			addUI(request, response);
		} else if ("add".equals(method)) {
			add(request, response);
		} else if ("forUpdateUserRoleUI".equals(method)) {
			forUpdateUserRoleUI(request, response);
		} else if ("updateRole".equals(method)) {
			updateRole(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		} else if ("logout".equals(method)) {
			logout(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = ss.find(username, password);
		if (u == null) {
			request.setAttribute("message", "username or password wrong...");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", u);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	private void updateRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String userid = request.getParameter("userid");
			String rids[] = request.getParameterValues("rid");
			ss.updateUserRole(userid, rids);
			request.setAttribute("message", "add successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to add...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void forUpdateUserRoleUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("id");
		User r =ss.findUser(uid);

		List<Role> list = ss.getAll();
		
		request.setAttribute("list", list);
		request.setAttribute("r", r);
		request.getRequestDispatcher("/security/updateUserRole.jsp")
				.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User r = WebUtils.request2Bean(request, User.class);
			r.setId(UUID.randomUUID().toString());
			ss.addUser(r);
			request.setAttribute("message", "add successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to add...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/security/adduser.jsp").forward(request,
				response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = ss.getAllUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/listuser.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
