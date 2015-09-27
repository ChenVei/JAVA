package cn.demo;

class Person {
	private PersonListener listener;
	public void run() {
		if (listener != null) {
			listener.dorun(new Even(this));
		}
		System.out.println("run...");
	}

	public void eat() {
		if (listener != null) {
			listener.doeat(new Even(this));
		}
		System.out.println("eat...");
	}

	public void registerListener(PersonListener listener) {
		this.listener = listener;
	}
}

interface PersonListener {
	
	public void dorun(Even e);
	public void doeat(Even e);
}

class Even {
	private Person person;

	public Even(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}

















