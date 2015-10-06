package cn.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Customer;
import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;
import cn.utils.Global;
import cn.utils.WebUtils;

public class EditCustomerServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		BusinessService bs = new BusinessServiceImpl();
		Customer c = bs.findCustomer(id);
		
		request.setAttribute("genders", Global.genders);
		request.setAttribute("preferences", Global.preferences);
		request.setAttribute("types", Global.types);
		request.setAttribute("c", c);
		
		request.getRequestDispatcher("/WEB-INF/jsp/editcustomer.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			Customer c = null;
			c = WebUtils.request2Bean(request, Customer.class);
			BusinessService bs = new BusinessServiceImpl();
			bs.updateCustomer(c);
			
			request.setAttribute("message", "update successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "fail to update...");
		} finally {
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
}
