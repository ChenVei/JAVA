package com.proxy;
import java.util.Random;


public class Tank implements Moveable {

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank Moving...");
		try {
			Thread.sleep(new Random().nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000);
	}
}
