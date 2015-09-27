package cn.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//display the product
public class CookieDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set the encoding type..
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// display the product
		String id = request.getParameter("id");
		Book b = DB.getAll().get(id);
		out.print(b.getId() + "<br/>");
		out.print(b.getName() + "<br/>");
		out.print(b.getAuthor() + "<br/>");
		out.print(b.getDescr() + "<br/>");

		// change the cookie
		Cookie[] c = request.getCookies();
		Cookie cookie = buildCookie(c, id);
		cookie.setPath("/Cookie_Session/");  // add '/' to the last
		response.addCookie(cookie);
	}

	private Cookie buildCookie(Cookie[] c, String id) {
		Cookie cookie = null;
		int cap = 3;
		if (c == null) {
			return new Cookie("bookHistory", id);
		}
		for (int i = 0; i < c.length; i++) {
			if ("bookHistory".equals(c[i].getName())) {
				String[] ids = c[i].getValue().split("\\,");
				LinkedList<String> l = new LinkedList<String>(
						Arrays.asList(ids));

				if (l.contains(id)) {
					l.remove(id);
				} else {
					if (l.size() >= cap) {
						l.removeLast();
					}	else {
						l.addFirst(id);
					}
				}
				l.addFirst(id);
				
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < l.size(); j++) {
					if (j == 0) {
						sb.append(l.get(j));
					} else {
						sb.append(","+l.get(j));
					}
				}	
				return new Cookie("bookHistory", sb.toString());
			}
		}

		return new Cookie("bookHistory", id);
	}

}
