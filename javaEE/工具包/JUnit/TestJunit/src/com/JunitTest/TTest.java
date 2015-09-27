package com.JunitTest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.T;

public class TTest {

	@Test
	public void testAdd() {
		int z = new T().add(3, 5);
		assertEquals(8, z);
		assertTrue("<=3",z>3);
		assertThat(8, is(8));
	}
	
	@Test(timeout=100) //finished in 100ms
	public void testDivide() {
		int z = new T().divide(8, 2); //watch this specific method
		assertThat(z, is(4));
	}
	@BeforeClass
	public static void beforeC2() {
		System.out.println("b2");
	}
	@BeforeClass
	public static void beforeC1() {
		System.out.println("b1");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("afterclass..");
	}
	@Before
	public void before() {
		System.out.println("before...");
	}
	@After
	public void after() {
		System.out.println("after!");
	}
}
