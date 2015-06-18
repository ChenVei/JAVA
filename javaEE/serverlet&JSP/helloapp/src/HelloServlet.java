package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("username");
		if (userName != null) {
			resp.sendError(resp.SC_FORBIDDEN);
		}
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html><head><title>HelloServlet~~</title></head>");
		pw.println("<body>Hello " + userName + "!!</body></html>");
		
		System.out.println("Befor:" + resp.isCommitted());
		pw.close();
		System.out.println("After:" + resp.isCommitted());
	}
	
}
