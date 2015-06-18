package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8"); //注意顺序
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html><head><title>RequestInfo~~</title></head>");
		pw.println("<body><br />LocalName:" + req.getLocalName());
		pw.println("<br />LocalAddr:" + req.getLocalAddr());
		pw.println("<br />LocalPort:" + req.getLocalPort());
		
		pw.println("<br />Protocol:" + req.getProtocol());
		pw.println("<br />RemoteAddr:" + req.getRemoteAddr());
		pw.println("<br />RemoteHost:" + req.getRemoteHost());
		pw.println("<br />RemotePort:" + req.getRemotePort());
		pw.println("<br />User:" + req.getRemoteUser());
		
		pw.println("<br />Method:" + req.getMethod());
		pw.println("<br />RequestURI:" + req.getRequestURI());
		pw.println("<br />ContextPath:" + req.getContextPath());
		pw.println("<br />QueryString:" + req.getQueryString());
		
		pw.println("<br>***打印HTTP请求头***");
		Enumeration<String> em =  req.getHeaderNames();
		String headName;
		for(;em.hasMoreElements();) {
			headName = em.nextElement();
			pw.println("<br />***" + headName + "***:" + req.getHeader(headName));
		}
		pw.println("<br>***打印HTTP请求头结束***<br>");
		
	    pw.println("<br>username: "+req.getParameter("username"));
		
		pw.println("</body></html>");
		
		pw.close();
		
	}
	
}
