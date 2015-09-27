package com.compiler.test;

import java.lang.reflect.Method;

import com.proxy.Moveable;
import com.proxy.Proxy;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException {
		Method[] methods = Moveable.class.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}
