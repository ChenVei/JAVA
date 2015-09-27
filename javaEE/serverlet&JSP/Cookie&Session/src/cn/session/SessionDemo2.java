package cn.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//buy
public class SessionDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//display the product
		String id = request.getParameter("id");
		Book b = DB.getAll().get(id);
		out.print(b.getId() + "<br/>");
		out.print(b.getName() + "<br/>");
		out.print(b.getAuthor() + "<br/>");
		out.print(b.getDescr() + "<br/>");
		
		
		HttpSession hs = request.getSession();
		hs.setAttribute(id, b);
		
		out.print("...you buy "+b.getName());
		
	}

}
