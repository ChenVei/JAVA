package struts2.front.action;

import struts2.user.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	User user;
	
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

}
