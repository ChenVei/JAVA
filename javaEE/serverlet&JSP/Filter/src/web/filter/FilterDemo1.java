package web.filter;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class FilterDemo1 implements Filter {
	private FilterConfig config;
	
	@Override
	public void destroy() {
		System.out.println("Destroy1!!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name = config.getInitParameter("name");
		Enumeration<String> enu = config.getInitParameterNames();
		while (enu.hasMoreElements()) {
			
			System.out.println(config.getInitParameter(enu.nextElement()));;
		}
		
		System.out.println("HELLO!");
		chain.doFilter(request, response);
		System.out.println("HAHAHA");
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config; 
		System.out.println("Create1!!");		
	}


	

}
