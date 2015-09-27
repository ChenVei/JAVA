package cn.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//cart
public class SessionDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("The books you buy:<br/>");
		
		HttpSession hs = request.getSession();
		Enumeration<String> en = hs.getAttributeNames();
		for(;en.hasMoreElements();) {
			String s = en.nextElement();
			out.println(((Book)hs.getAttribute(s)).getName());
		}
	}

}
