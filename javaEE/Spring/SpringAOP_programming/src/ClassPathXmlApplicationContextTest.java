


import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.LogInterceptor;
import com.dao.UserDao;
import com.dao.impl.UserDAOImpl;
import com.model.User;
import com.service.UserService;

public class ClassPathXmlApplicationContextTest {

	@Test
	public void testClassPathXmlApplicationContext() throws Exception {
		ApplicationContext c = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService) c.getBean("userService");
		User u = new User();
		us.add(u);
	}
	
	@Test
	public void testProxy() {  //Dynamic Proxy
		UserDao userDAO = new UserDAOImpl();
//****************************************************
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDAO);
		UserDao uProxy = (UserDao)Proxy.newProxyInstance(UserDao.class.getClassLoader(), UserDAOImpl.class.getInterfaces(), li);
//****************************************************//add new service logic
		uProxy.save(new User());  //
		uProxy.delete(new User());
	}
}












