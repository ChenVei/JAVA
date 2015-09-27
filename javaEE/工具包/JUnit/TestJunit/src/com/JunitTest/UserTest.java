package com.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.User;

import static org.hamcrest.Matchers.*;
public class UserTest {

	@Test
	public void testGetName() {
		assertThat(new User().getName(), is("WS"));
	}

}
