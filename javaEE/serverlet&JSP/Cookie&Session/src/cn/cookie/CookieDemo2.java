package cn.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//display all products:
		out.println("Our products:<br/>");
		Map<String, Book> map = DB.getAll();
		for (Map.Entry<String, Book> entry: map.entrySet()) {
			Book b = entry.getValue();
			out.println("<a href='/Cookie_Session/servlet/CookieDemo3?id="+b.getId()+"' target='_blank'>"+b.getId()+"----"+b.getName()+"</a><br/>");
		}
		//display last visited by time
		out.print("last visited:<br/>");
		Cookie[] c = request.getCookies();
		for (int i = 0; c != null && i < c.length; i++) {
			if ("bookHistory".equals(c[i].getName())) {
				String ids[] = c[i].getValue().split("\\,");
				for (String id : ids) {
					Book b = map.get(id);
					out.print(b.getName()+"<br/>");
				}
			}
		}
out.print("*********************************<br/>");
for (int i = 0; c != null && i < c.length; i++) {
	out.print(c[i].getName()+"----"+c[i].getValue()+"<br/>");
}
	}

}

class DB {
	private static Map<String, Book> map = new LinkedHashMap<String, Book>();
	static {
		map.put("1", new Book(1, "JAVA-web权威指南", "xx", "aa"));
		map.put("2", new Book(2, "AJAX权威指南", "xx", "aa"));
		map.put("3", new Book(3, "spring权威指南", "zz", "aa"));
		map.put("4", new Book(4, "struts权威指南", "yy", "aa"));
		map.put("5", new Book(5, "hibernate权威指南", "uuu", "aa"));
	}
	public static Map<String, Book> getAll() {
		return map;
	}
}

class Book {
	private int id;
	private String name;
	private String author;
	private String descr;
	
	public Book(int id, String name, String author, String descr) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.descr = descr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
}











