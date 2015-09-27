package com.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dao.StudentDAO;
import com.domain.Student;

public class DAOTest {

	@Test
	public void testAdd() {
		Student s = new Student("Ws", 19, "male", 78);
		StudentDAO.save(s);
	}
	
	@Test
	public void testDelete() {
		StudentDAO.delete("Ws");
	}
	
	@Test
	public void testFind() {
		Student s = StudentDAO.find("cc");
		System.out.println(s);
	}
}
