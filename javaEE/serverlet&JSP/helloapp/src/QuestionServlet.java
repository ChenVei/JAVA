package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.print("Initial");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletConfig sc = getServletConfig();
		PrintWriter pw = resp.getWriter();
		
		//sc为null，因此会抛出NullPointerException
		pw.println(sc.getServletName());
		pw.close();
	}
	
}
