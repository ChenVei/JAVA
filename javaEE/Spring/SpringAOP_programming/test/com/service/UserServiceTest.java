package com.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.model.User;

public class UserServiceTest {

	@Test
	public void testAdd() {
		UserService s = new UserService();
		User u = new User();
		s.add(u);
	}

}
