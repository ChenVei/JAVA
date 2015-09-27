package cn.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//display books
public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Map<String, Book> map = DB.getAll();
		
		for (Entry<String, Book> en : map.entrySet()) {
			Book b = en.getValue();
			out.println(en.getKey()+"---"+b.getName());
			out.println("<a href='"+getServletContext().getContextPath()+"/servlet/SessionDemo2?id="+en.getKey()+"'>buy</a><br/>");
		}
		
		out.println("<a href='"+getServletContext().getContextPath()+"/servlet/SessionDemo3'>Cart</a>");
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











