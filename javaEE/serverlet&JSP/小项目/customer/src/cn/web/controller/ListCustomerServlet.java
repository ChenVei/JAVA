package cn.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Customer;
import cn.domain.PageBean;
import cn.domain.QueryInfo;
import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;
import cn.utils.WebUtils;

public class ListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			QueryInfo qi = WebUtils.request2Bean(request, QueryInfo.class);
			BusinessService bs = new BusinessServiceImpl();
			PageBean pb = bs.pageQuery(qi);
			
			request.setAttribute("pagebean", pb);
			request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "fail to load user's page");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
