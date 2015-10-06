package cn.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.domain.Resource;
import cn.domain.User;
import cn.service.SecurityService;

public class SecurityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("message", "go to login first...");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		SecurityService ss = new SecurityService();
		String uri = request.getRequestURI();
		Resource r = ss.findResource(uri);
		if (r == null) {
			chain.doFilter(request, response);
			return;
		}
		
		Privilege p = r.getPrivilege();
		List<Privilege> list = ss.getUserAllPrivileges(user.getId());
		if (!list.contains(p)) {
			request.setAttribute("message", "you don't have enough privilege...");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
