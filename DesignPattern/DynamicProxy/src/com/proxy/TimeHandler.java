package com.proxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
	
	private Object target;
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}
	@Override
	public void invoke(Object o, Method m) {
		System.out.println("Invoke Tank time start...");
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Invoke Tank time end...");
	}
}
