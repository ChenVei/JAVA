public class Test {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World";
		String s3 = "HelloWorld";
		String s4 = s1.concat(s2);
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		change(s1,s2);
		System.out.println(s1+"---"+s2);
		
		StringBuilder ss1 = new StringBuilder("Hello");
		StringBuilder ss2 = new StringBuilder("World");
		change(ss1,ss2);
		System.out.println(ss1+"----"+ss2);
		
		Person p1 = new Person(10, "lw"), p2 = new Person(20, "ws");
		try {
			p2.finalize();
		} catch (Throwable e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(p1+"---"+p2);
		System.gc();
	}

	private static void change(StringBuilder s1, StringBuilder s2) {
		s1 = s2;
		s2.append(s1);
	}

	private static void change(String s1, String s2) {
		s1 = s2;
		s2 = s1 + s2;
	}
}


class Person {
	/**
	 * @param age
	 * @param name
	 */
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










