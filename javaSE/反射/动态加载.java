
public class Test {

	public static void main(String[] args) {
		new A();
		System.out.println("********");
		new B();
		
		new C();new C();
		new D();new D();
	}

}
class A {
	
}
class B {
	
}
class C {
	static {
		System.out.println("xxxxx");
	}
}
class D {
	{
		System.out.println("aaaaa");
	}
}