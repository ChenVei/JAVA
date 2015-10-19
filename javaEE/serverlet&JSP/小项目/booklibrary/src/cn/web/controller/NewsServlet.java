package cn.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
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
import cn.dao.impl.NewsDaoImpl;
import cn.domain.Book;
import cn.domain.News;
import cn.service.BusinessService;
import cn.service.impl.BusinessServiceImpl;

public class NewsServlet extends HttpServlet {
	
	final String NEWS_ADD = "NEWS_ADD";
	final String NEWS_UPDATE = "NEWS_UPDATE";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		request.setAttribute("method", method);
		if ("addNews".equals(method)) {
			addNews(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} 
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || id.equals("")) {
			request.setAttribute("message", "fail to delete the news...");
		} else {
			BusinessServiceImpl bs = new BusinessServiceImpl();
			bs.deleteNews(Integer.parseInt(id));
			request.setAttribute("message", "delete the news successfully...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void addNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			updateCover(request, response, NEWS_ADD);
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

		for (FileItem item : lf) {
			if (item.isFormField()) { // ordinary input
				String name = item.getFieldName();
				String value = item.getString("utf-8");
				map.put(name, value);
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
		
		News n = new News();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(n, map);
		NewsDaoImpl nd = new NewsDaoImpl();
		int id = -1;
		
		if (method.equals(NEWS_ADD)) {
			n.setPdate(new Timestamp(new Date().getTime()));
			id = nd.add(n);
			request.setAttribute("message", "add news successfully...");
		} else {
			id = Integer.parseInt(map.get("id"));
			n.setId(id);
			nd.update(n);
			request.setAttribute("message", "update news successfully...");
		}
		
		if (fi != null) {  //upload file
			InputStream is = fi.getInputStream();
			String Spath = getServletContext().getRealPath(
					"/img/newscover/"); 
			System.out.println(Spath);
			FileOutputStream fos = new FileOutputStream(new File(Spath + id
					+ ".jpg"));
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = is.read(b)) > 0) {
				fos.write(b, 0, len);
			}
			fos.close();
			is.close();
			fi.delete(); // the temporary file would be deleted.
		}

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
