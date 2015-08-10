package struts2.front.action;

import struts2.user.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction1 extends ActionSupport implements ModelDriven<User>{
	User user = new User();   //new a object by yourself
	
	public String add() {
		System.out.println("Username:"+user.getName());
		System.out.println("Userage:"+user.getAge());
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}

}
