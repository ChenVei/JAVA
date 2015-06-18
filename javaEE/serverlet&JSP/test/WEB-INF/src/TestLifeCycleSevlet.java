import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
加载     ClassLoader
实例化	 new
初始化	 init(ServletConfig)
处理请求 service doGet doPost
退出服务 destroy
*/

public class TestLifeCycle extends HttpServlet {
	
	
	@Override
	public void destroy() {
		System.out.println("destroy!");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init!");
	}
	
	public TestLifeCycle() {
		System.out.println("Constructor");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet!");
		//获取输出流
		response.getWriter().write("<a href=http://baidu.com>Go</a>");
	}


	
}
