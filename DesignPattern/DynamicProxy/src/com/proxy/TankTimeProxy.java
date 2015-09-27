package com.proxy;

import java.lang.reflect.Method;

public class TankTimeProxy implements com.proxy.Moveable {
	InvocationHandler h;

	public TankTimeProxy(InvocationHandler h) {
		this.h = h;
	}

	@Override
	public void move() {
		Method md = null;
		try {
			md = com.proxy.Moveable.class.getMethod("move");
			h.invoke(this, md);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}