package cn.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;

public class DelCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			BusinessService bs = new BusinessServiceImpl();
			bs.removeCustomer(id);
			request.setAttribute("message", "delete successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "fail to delete!");
		} finally {
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
