package com.domain;

public class Student {
	private int age;
	private int grade;
	private String name;
	private String sex;
	
	public Student() {
	}
	
	public Student(String name, int age, String sex, int grade) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}
	public int getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", grade=" + grade + ", name=" + name
				+ ", sex=" + sex + "]";
	}
}
