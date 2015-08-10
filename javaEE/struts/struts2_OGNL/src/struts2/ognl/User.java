package struts2.ognl;

public class User {
	int age = 8;

	public User() {
		System.out.println("using User's constructor!");
	}

	public User(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "age:" + age;
	}
	
}
