package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextTesterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		ServletContext sc = getServletContext();
		
		resp.setContentType("text/html");
		
		pw.println("<html><head><title>ContextTester</title><head>");
		pw.println("<body><br />Email:" + sc.getInitParameter("emailOfwebmaster"));
		pw.println("<br />Path:" + sc.getRealPath("/WEB-INF"));
		pw.println("<br />MimeType:" + sc.getMimeType("/WEB-INF/web.xml"));
		pw.println("<br />MajorVersion:" + sc.getMajorVersion());
		pw.println("<br />ServerInfo:" + sc.getServerInfo());
		pw.println("</body></html>");
		
		sc.log("这是ContextTesterServlet输出的日志。");
		pw.close();
	}
	
}
