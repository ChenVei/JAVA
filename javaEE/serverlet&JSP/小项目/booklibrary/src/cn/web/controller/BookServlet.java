package cn.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import cn.dao.impl.BookDaoImpl;
import cn.domain.Book;
import cn.domain.Category;
import cn.domain.PageBean;
import cn.domain.QueryInfo;
import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;
import cn.utils.WebUtils;

public class BookServlet extends HttpServlet {
	
	final String BOOK_ADD = "BOOK_ADD";
	final String BOOK_UPDATE = "BOOK_UPDATE";
	
	BusinessService bs = new BusinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		request.setAttribute("method", method);
		if ("addBookUI".equals(method)) {
			addBookUI(request, response);
		} else if ("listBook".equals(method)) {
			listBook(request, response);
		} else if ("delBook".equals(method)) {
			delBook(request, response);
		} else if ("addBook".equals(method)) {
			addBook(request, response);
		} else if ("updateBook".equals(method)) {
			updateBook(request, response);
		} else if ("updateBookUI".equals(method)) {
			updateBookUI(request, response);
		} else if ("query".equals(method)) {
			query(request, response);
		}
	}
	
	private void listBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		List<Book> list = bs.getBooks();
		QueryInfo qi = WebUtils.request2Bean(request, QueryInfo.class);
		PageBean<Book> pb = bs.queryBook(qi);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/WEB-INF/jsp/listbook.jsp").forward(
				request, response);
	}
	
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		QueryInfo qi = WebUtils.request2Bean(request, QueryInfo.class);
		qi.setQueryString(name);
		
		BusinessServiceImpl bsi = new BusinessServiceImpl();
		PageBean<Book> pb = bsi.querySpecficBook(qi);
		request.setAttribute("pb", pb);
		
		request.getRequestDispatcher("/WEB-INF/jsp/listbook.jsp").forward(
				request, response);
	}

	private void updateBookUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Book b = bs.findBookById(Integer.parseInt(id));
		List<Category> list = bs.getAllCategories();
		request.setAttribute("b", b);
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/jsp/updatebook.jsp").forward(
				request, response);
	}
	
	private void delBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || id.equals("")) {
			request.setAttribute("message", "fail to delete the book...");
		} else {
			BusinessService bs = new BusinessServiceImpl();
			bs.deleteBook(Integer.parseInt(id));
			request.setAttribute("message", "delete the book successfully...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	private void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			updateCover(request, response, BOOK_UPDATE);
			/*Book b = WebUtils.request2Bean(request, Book.class);
			bs.updateBook(b);
			bs.updateCategory(b.getId(), request.getParameter("cats")
					.split(","));*/
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "fail to update...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			updateCover(request, response, BOOK_ADD);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "fail to add...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void updateCover(HttpServletRequest request,
			HttpServletResponse response, final String method) throws FileUploadException,
			ServletException, IOException, IllegalAccessException,
			InvocationTargetException {
		List<String> types = Arrays.asList(".jpg", ".gif", ".png", ".jpeg"); // supported
																				// type

		DiskFileItemFactory dfi = new DiskFileItemFactory(); // apache's
																// component

		dfi.setSizeThreshold(1024 * 1024); // 1M, and default is 10k, and
											// excessed will be saved in the
											// cache file
		String path = getServletContext().getRealPath("/WEB-INF/temp");
		dfi.setRepository(new File(path)); // temporary cached file

		ServletFileUpload sf = new ServletFileUpload(dfi);
		sf.setHeaderEncoding("utf-8");
		// sf.setFileSizeMax(1024*1024*5); //set single file's max size

		List<FileItem> lf = sf.parseRequest(new ServletRequestContext(request));
		Map<String, String> map = new HashMap<String, String>();
		List<String> idf = new LinkedList<String>();
		FileItem fi = null;  // for stream file
		String ids[];

		for (FileItem item : lf) {
			if (item.isFormField()) { // ordinary input
				String name = item.getFieldName();
				String value = item.getString("utf-8");
				map.put(name, value);
				if ("category".equals(name)) {
					idf.add(value);
				}
				System.out.println(name + " " + value);
			} 
			else { // stream
				String name = item.getName();
				if (name == null || "".equals(name)) {
					continue;
				}
				String ext = name.substring(name.lastIndexOf("."));
				System.out.println(ext);
				if (!types.contains(ext.toLowerCase())) {
					request.setAttribute("message",
							"sorryia..  i don't support type " + ext);
					return;
				}
				
				fi = item;
			}
		}
		
		Book book = new Book();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(book, map);
		BookDaoImpl bdi = new BookDaoImpl();
		ids = new String[idf.size()];
		idf.toArray(ids);
		int id;
		
		if (method.equals(BOOK_ADD)) {
			id = bdi.add(book, ids);
			request.setAttribute("message", "add book successfully...");
		} else {
			id = Integer.parseInt(map.get("id"));
			book.setId(id);
			bdi.update(book);
			bdi.updateCategory(id, ids);
			request.setAttribute("message", "update book successfully...");
		}
		
		if (fi != null) {  //upload file
			InputStream is = fi.getInputStream();
			String Spath = getServletContext().getRealPath(
					"/img/bookcover/"); 
			System.out.println(Spath);
			FileOutputStream fos = new FileOutputStream(new File(Spath + id
					+ ".jpg"));
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = is.read(b)) > 0) {
				fos.write(b);
			}
			fos.close();
			is.close();
			fi.delete(); // the temporary file would be deleted.
		}

	}

	private void addBookUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> list = bs.getAllCategories();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/addbook.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
