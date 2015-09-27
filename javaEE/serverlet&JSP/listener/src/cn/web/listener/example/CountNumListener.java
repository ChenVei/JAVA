package cn.web.listener.example;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountNumListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext s = se.getSession().getServletContext();
		Integer cnt = (Integer) s.getAttribute("count");
		if (cnt == null) {
			cnt = 1;
			s.setAttribute("count", cnt);
		} else {
			s.setAttribute("count", cnt + 1);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext s = se.getSession().getServletContext();
		Integer cnt = (Integer) s.getAttribute("count");
		s.setAttribute("count", cnt - 1);
	}
}
