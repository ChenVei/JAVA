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

public class AddCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("genders", Global.genders);
		request.setAttribute("preferences", Global.preferences);
		request.setAttribute("types", Global.types);

		request.getRequestDispatcher("/WEB-INF/jsp/addcustomer.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			Map<String, String[]> map = request.getParameterMap();
			Customer c = WebUtils.request2Bean(request, Customer.class);
			c.setId(WebUtils.generateID());
			BusinessService bs = new BusinessServiceImpl();
			bs.addCustomer(c);
			request.setAttribute("message", "add successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "fail to add !");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
