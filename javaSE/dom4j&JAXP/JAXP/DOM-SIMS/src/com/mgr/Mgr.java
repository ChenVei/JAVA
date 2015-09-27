package com.mgr;

import com.dao.StudentDAO;
import com.domain.Student;

public class Mgr {
	public static void save(Student s) {
		StudentDAO.save(s);
		System.out.println("SAVE SUCCESSFULLY...");
	}
	
	public static void find(String name) {
		Student s = StudentDAO.find(name);
		if (s == null) {
			System.out.println("NO SUCH GUY!");
			return;
		}
		System.out.println("HIS INFORMATION:\n"+s);
	}
	
	public static void delete(String name) {
		boolean ok = StudentDAO.delete(name);
		if (ok) {
			System.out.println("KILL HIM Successfully...");
		} else {
			System.out.println("NO SUCH GUY");
		}
	}
}
