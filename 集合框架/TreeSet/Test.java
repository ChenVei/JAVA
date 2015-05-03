import java.util.Comparator;
import java.util.TreeSet;


public class Test {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();  //自然排序
		ts.add(5);ts.add(6);ts.add(4);ts.add(8);ts.add(2);ts.add(4);ts.add(7);
		System.out.println(ts);
		
		//TreeSet<Student> ts2 = new TreeSet<Student>();  //自然排序
		//TreeSet<Student> ts2 = new TreeSet<Student>(new MyComparator());  //比较器排序
		TreeSet<Student> ts2 = new TreeSet<Student>(new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				// TODO 自动生成的方法存根
				int k = s1.getName().compareTo(s2.getName());
				if (k == 0) {
					return 0;
				}
				int num1 = s1.getAge() - s2.getAge();
				int num2 = num1 == 0?k:num1;
				return num2;
			}
		});
				
		Student s1 = new Student("lw",20),s2 = new Student("ws",19),s3 = new Student("hq",19),s4 = new Student("pz",21),s5 = new Student("ws",19),s6 = new Student("ws",25);
		ts2.add(s1);ts2.add(s2);ts2.add(s3);ts2.add(s4);ts2.add(s5);ts2.add(s6);
		for (Student s : ts2) {
			System.out.println(s.getName()+"-----"+s.getAge());
		}
	}
}
class MyComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		// TODO 自动生成的方法存根
		int k = s1.getName().compareTo(s2.getName());
		if (k == 0) {
			return 0;
		}
		int num1 = s1.getAge() - s2.getAge();
		int num2 = num1 == 0?k:num1;
		return num2;
	}
	
}


class Student implements Comparable<Student>{
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
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
	@Override
	public int compareTo(Student s) {
		//return 0;
		//return 1;
		//return -1;
		int k = name.compareTo(s.name);
		if (k == 0) {
			return 0;
		}
		int num1 = age - s.age;
		int num2 = num1 == 0?k:num1;
		return num2;
		
	}
	
}