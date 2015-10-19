package cn.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.impl.CategoryDaoImpl;
import cn.domain.Book;
import cn.domain.Category;
import cn.domain.News;
import cn.domain.PageBean;
import cn.domain.QueryInfo;
import cn.domain.QueryResult;
import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;
import cn.utils.WebUtils;

public class UIServlet extends HttpServlet {

	BusinessService bs = new BusinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		request.setAttribute("method", method);
		if ("getAll".equals(method)) {
			getAll(request, response);
		} else if ("getSpecfic".equals(method)) {
			getSpecfic(request, response);
		} else if ("getSpecficNews".equals(method)) {
			getSpecficNews(request, response);
		} else if ("getAllNews".equals(method)) {
			getAllNews(request, response);
		}
	}

	private void getAllNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<News> list = bs.getAllNews();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/front/listnews.jsp").forward(request,
				response);
	}

	private void getSpecficNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		News n = bs.findNews(Integer.parseInt(id));

		request.setAttribute("n", n);
		request.getRequestDispatcher("/front/news.jsp").forward(request,
				response);
	}

	private void getSpecfic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		QueryInfo qi = WebUtils.request2Bean(request, QueryInfo.class);
		qi.setQueryString(name);

		BusinessService bsi = new BusinessServiceImpl();
		PageBean<Book> pb = bsi.querySpecficBook(qi);
		request.setAttribute("pb", pb);

		List<Category> list = bs.getAllCategories();
		request.setAttribute("list", list);

		request.getRequestDispatcher("/front/list.jsp").forward(request,
				response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDaoImpl cdi = new CategoryDaoImpl();
		QueryInfo qi = WebUtils.request2Bean(request, QueryInfo.class);
		String cid = request.getParameter("cid");
		QueryResult<Book> qr = cdi.getBooksByCategory(qi, cid);
		PageBean<Book> pb = new PageBean<Book>(qi, qr);
		List<Category> list = bs.getAllCategories();
		request.setAttribute("list", list);

		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/front/list.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
