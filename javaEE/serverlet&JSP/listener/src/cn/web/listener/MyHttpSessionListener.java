package cn.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyHttpSessionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("---Context Start....");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("---Context End....");
	}

}
