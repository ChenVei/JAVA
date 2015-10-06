package cn.domain;

import java.util.Date;

public class User {
	int age;
	String name;
	Date birth;
	float money;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", birth=" + birth
				+ ", money=" + money + "]";
	}
}
