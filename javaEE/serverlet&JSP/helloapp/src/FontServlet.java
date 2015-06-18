package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FontServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String color = getInitParameter("color");
		String size = getInitParameter("size");
		String word =  getInitParameter("word");
		if (word == null) {
			word = "Hello World~";
		}
		System.out.println(getServletName());
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html><head><title>RequestInfo~~</title></head>");
		pw.println("<body><p style=\"color:" + color + ";size:" + size + "\">" + word + "</p></body>");
		
		pw.close();
	}
	
}
