package cn.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyServletContextListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("---session Start...");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("---session End...");
	}


}
