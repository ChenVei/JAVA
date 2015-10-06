package cn.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Category;
import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;
import cn.utils.WebUtils;

public class CategoryServlet extends HttpServlet {

	BusinessService bs = new BusinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String method = request.getParameter("method");
		if ("addCategoryUI".equals(method)) {
			addCategoryUI(request, response);
		} else if ("listCategory".equals(method)) {
			listCategory(request, response);
		} else if ("delCategory".equals(method)) {
			delCategory(request, response);
		} else if ("addCategory".equals(method)) {
			addCategory(request, response);
		}
	}

	private void delCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		try {
			bs.deleteCategory(Integer.valueOf(id));
			request.setAttribute("message", "delete successfully...");
		} catch (Exception e) {
			request.setAttribute("message", "fail to delete...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			Category c = WebUtils.request2Bean(request, Category.class);
			BusinessService bs = new BusinessServiceImpl();
			bs.addCategory(c);
			request.setAttribute("message", "add category successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "fail to add...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void listCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> list = bs.getAllCategories();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/categorylist.jsp").forward(
				request, response);
	}

	private void addCategoryUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addcategory.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
