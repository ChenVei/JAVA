package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {
	int init, serv, dest;
	String name;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		name = config.getServletName();
		
		init++;
		System.out.println(name+">init(): Servlet����ʼ����" + init + "��");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		serv++;
		System.out.println(name+">service(): Servlet����Ӧ��" + serv + "������");

	    String content1="��ʼ������ : "+ init;
	    String content2="��Ӧ�ͻ�������� : "+ serv;
	    String content3="���ٴ��� : "+dest;

	    resp.setContentType("text/html;charset=GB2312");

	    PrintWriter out = resp.getWriter();
	    out.print("<html><head><title>LifeServlet</title>");
	    out.print("</head><body>");
	    out.print("<h1>"+content1 +"</h1>");
	    out.print("<h1>"+content2 +"</h1>");
	    out.print("<h1>"+content3 +"</h1>");
	    out.print("</body></html>");
	    out.close();
	}

	@Override
	public void destroy() {
		dest++;
		System.out.println(name+">destroy(): Servlet��������" + dest + "��");
	}

	
	
}
