package cn.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDemo2 {

	@Test
	public void test() {
		Person p = new Person();
		p.registerListener(new MyListener());
		p.eat();
		p.run();
	}
	
	class MyListener implements PersonListener {

		public void dorun(Even e) {
			System.out.println(e.getPerson() + "xxxxxxx");
		}

		public void doeat(Even e) {
			System.out.println(e.getPerson() + "yyyyyyy");
		}
		
	}
}
