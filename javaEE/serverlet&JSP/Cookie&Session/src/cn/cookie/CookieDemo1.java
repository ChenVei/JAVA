package cn.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//clear cookie..
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] c = request.getCookies();
		for (int i = 0; c != null && i < c.length; i++) {
			System.out.println(c[i].getName()+"----"+c[i].getValue());
			c[i].setMaxAge(-1);
			response.addCookie(c[i]);
		}
		
		
		out.print("delete successfully...");
	}

}





