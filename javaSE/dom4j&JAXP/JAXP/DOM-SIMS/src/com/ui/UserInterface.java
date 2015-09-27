package com.ui;

import java.util.Scanner;

import com.domain.Student;
import com.mgr.Mgr;

public class UserInterface {

	public static void main(String[] args) {
		System.out.println("Hello, I want to play a game with you..");
		System.out
				.println("please choose A(find), B(add), C(delete), others to quit...");
		Scanner s = new Scanner(System.in);
		char c = Character.toUpperCase(s.next().charAt(0));

		while (c == 'A' || c == 'B' || c == 'C') {
			String name;
			int age;
			String sex;
			int grade;
			switch (c) {
			case 'A':
				System.out.print("INPUT THE GUY YOU WANNA:");
				name = s.next();
				Mgr.find(name);
				break;
			case 'B':
				System.out.println("INPUT THE GUY'S INFO:");
				System.out.println("HIS NAME:");
				name = s.next();
				System.out.println("HIS AGE:");
				age = s.nextInt();
				System.out.println("HIS SEX:");
				sex = s.next();
				System.out.println("HIS GRADE:");
				grade = s.nextInt();
				Mgr.save(new Student(name, age, sex, grade));
				break;
			case 'C':
				System.out.print("INPUT THE GUY YOU WANNA KILL:");
				name = s.next();
				Mgr.delete(name);
				break;
			}
			System.out
			.println("please choose A(find), B(add), C(delete), others to quit...");
			c = Character.toUpperCase(s.next().charAt(0));
		}
	}

}
