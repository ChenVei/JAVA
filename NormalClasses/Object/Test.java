
public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student s = new Student();
		System.out.println(s.getClass());
		System.out.println(s.getClass().getName());
		
		Object obj = s.clone();
		Student s2 = (Student)obj;
		System.out.println(s+"------"+s2);
	}
}
class Student implements Cloneable{
	int age;
	String name;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO �Զ����ɵķ������
		return super.clone();
	}
}