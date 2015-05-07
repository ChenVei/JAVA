public class Test {
	public static void main(String[] args) throws Throwable {
		Person p1 = new Person(10, "lw"), p2 = new Person(20, "ws");
		
		p2.finalize();  //throws Throwable 
		System.out.println(p1+"\n"+p2);
		
		p2 = p1;
		System.gc();
		System.out.println(p1+"\n"+p2);
		
		long now = System.currentTimeMillis();
		Thread.sleep(3000);
		System.out.println(System.currentTimeMillis() - now);
	}
}

class Person {
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	int age = 10;
	String name = "ws";
	@Override
	protected void finalize() throws Throwable {
		System.out.println(this+" was killed");
		super.finalize();
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
}



