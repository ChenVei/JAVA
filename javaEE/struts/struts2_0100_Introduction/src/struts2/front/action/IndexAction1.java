package struts2.front.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction1 extends ActionSupport{
	private String name;
	private int age;
//	public String execute() throws Exception {
//		return "x123";
//	}
	
	//must be public
	public String add() {  
		if (age < 18) {
			addFieldError("Age", "how old are you?");
			addFieldError("age", "too young");
			addFieldError("age", "too naive");
			return ERROR;
		}
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		return "x123";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
