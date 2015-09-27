package cn.web.listener.example;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionScanner implements HttpSessionListener,
		ServletContextListener {

	private List<HttpSession> list = Collections
			.synchronizedList(new LinkedList<HttpSession>());
	
	private Object lock = new Object();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Timer t = new Timer();
		t.schedule(new MyTask(list, lock), 0, 5*60*1000);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession hs = se.getSession();
		System.out.println(hs + " is created...");
		synchronized (lock) {  //锁旗标
			list.add(hs);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(se.getSession() + " is destroyed...");
	}

}

class MyTask extends TimerTask {
	
	private List<HttpSession> list;
	private Object lock;
	
	public MyTask(List<HttpSession> list, Object lock) {
		this.list = list;
		this.lock = lock;
	}
	
	public void run() {
		System.out.println("Timer executing.....");
		synchronized (lock) {
			ListIterator<HttpSession> it = list.listIterator();
			while(it.hasNext()) {
				HttpSession s = it.next();
				if ((System.currentTimeMillis() - s.getLastAccessedTime()) > 5*60*1000) {
					s.invalidate();
					it.remove();
				}
			}
		}
	}
}








