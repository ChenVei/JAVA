package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.dao.UserDao;
import com.model.User;

public class LogInterceptor implements InvocationHandler {
	private Object target;
	
	public void beforeMethod(Method m) {
		System.out.println(m.getName()+" method start...");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		beforeMethod(method);
		method.invoke(target, args);
		return null;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	
}
