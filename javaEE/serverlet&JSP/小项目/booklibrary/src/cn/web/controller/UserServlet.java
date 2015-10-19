package cn.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.User;
import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;
import cn.utils.WebUtils;

public class UserServlet extends HttpServlet {
	
	BusinessService bs = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if ("delete".equals(method)) {
			delete(request, response);
		} else if ("getAll".equals(method)) {
			getAll(request, response);
		} else if ("forUpdate".equals(method)) {
			forUpdate(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		} else if ("add".equals(method)) {
			add(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		} else if ("quit".equals(method)) {
			quit(request, response);
		}
	}

	private void quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = bs.find(username, password);
		if (u != null) {
			request.getSession().setAttribute("user", u);
			String cat = request.getParameter("cat");
			if (cat != null && "back".equals(cat)) {
				response.sendRedirect("../back/main.jsp");
//				request.getRequestDispatcher("/back/main.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/front/index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "username or password wrong...");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User u = WebUtils.request2Bean(request, User.class);
			bs.addUser(u);
			request.getSession().setAttribute("user", u);
			request.getRequestDispatcher("/front/index.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "fail to add...");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User u = WebUtils.request2Bean(request, User.class);
			bs.update(u);
			request.setAttribute("message", "update successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to update...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void forUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User u = bs.find(Integer.valueOf(id));
		request.setAttribute("u", u);
		request.getRequestDispatcher("/WEB-INF/jsp/updateuser.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<User> list = bs.getAllUsers();
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("/WEB-INF/jsp/listuser.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			bs.deleteUser(Integer.valueOf(id));
			request.setAttribute("message", "delete successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to delete...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
