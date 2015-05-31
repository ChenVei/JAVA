package reflect0;

public class ReflectDemo {
	public static void main(String[] args) {
		//��ʽ1��Object ���getClass()����		
		Person p = new Person();
		Class c = p.getClass();

		Person p2 = new Person();
		Class c2 = p2.getClass();
		
		System.out.println(p == p2);  //false
		System.out.println(c == c2);  //true
		
		//��ʽ2���������͵ľ�̬����
		Class c3 = Person.class;
		System.out.println(c == c3);  //true
		
		//��ʽ3��Class��ľ�̬����forName();
		try {
			Class c4 = Class.forName("reflect0.Person");
			System.out.println(c == c4);  //true
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

package reflect0;

public class Person {
	private String name;
	int age;
	public String address;

	public Person() {
	}

	private Person(String name) {
		super();
		this.name = name;
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void show() {
		System.out.println("show!");
	}

	public void method(String s) {
		System.out.println("method:" + s);
	}
	
	private void function() {
		System.out.println("function");
	}

	public String getString(String s, int i) {
		return s + "---" + i;
	}
	
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}
}