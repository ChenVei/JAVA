package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		Counter c = (Counter) sc.getAttribute("counter");
		
		if (c == null) {
			c  = new Counter(1);
			sc.setAttribute("counter", c);
		}
		
		resp.setContentType("text/html;charset=GB2312");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html><head><title>CounterServlet</title></head>");
	    pw.println("<body>");
	    
	    pw.println("<h1>欢迎光临本站。您是第 " + c.getCount()+" 位访问者。</h1>");
	    pw.println("</body></html>");
		pw.println();
		pw.close();
		
		c.add(1);
		
	}
	
}







