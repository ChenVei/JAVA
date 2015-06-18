package mypack;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet1 extends HttpServlet {
	ServletContext sc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("CounterServlet1 is Initialized.");
		super.init(config);
		sc = getServletContext();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getResourceAsStream("/count/count.txt")));
			int n = Integer.parseInt(br.readLine());
			br.close();
			
			Counter c = new Counter(n);
			sc.setAttribute("cnt", c);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Counter c = (Counter) sc.getAttribute("cnt");
		if (c == null) {
			c = new Counter(100);
		}
		resp.setContentType("text/html;charset=GB2312");
		
		PrintWriter out = resp.getWriter();
	    out.println("<html><head><title>CounterServlet</title></head>");
	    out.println("<body>");
	    // 输出当前的counter属性
	    out.println("<h1>欢迎光临本站。您是第 " + c.getCount()+" 位访问者。</h1>");
	    out.println("</body></html>");
	    
	    c.add(1);
	    out.close();
	}	
	
	@Override
	public void destroy() {
		System.out.println("CounterServlet1 is Destroyed.");
		Counter c = (Counter) sc.getAttribute("cnt");
		String path = sc.getRealPath("/count/count.txt");
		try {
			PrintWriter pw = new PrintWriter(path);
			pw.println(c.getCount());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	
	
}
