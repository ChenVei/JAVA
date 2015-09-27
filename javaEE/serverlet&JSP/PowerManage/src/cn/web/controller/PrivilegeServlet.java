package cn.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.service.SecurityService;
import cn.utils.WebUtils;

public class PrivilegeServlet extends HttpServlet {
	
	private SecurityService service = new SecurityService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("getAll".equals(method)) {
			getAll(request,response);
		} else if ("add".equals(method)) {
			add(request,response);
		} else if ("addUI".equals(method)) {
			addUI(request,response);
		}
		
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/security/addprivilege.jsp").forward(request, response);		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Privilege p = WebUtils.request2Bean(request, Privilege.class);
			p.setId(UUID.randomUUID().toString());
			service.addPrivilege(p);
			request.setAttribute("message", "add successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to add...");			
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Privilege> list = service.getAllPrivilege();
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("/security/listprivilege.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
