
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("aa");set.add("Bb");set.add("cc");set.add("aa");set.add("dd");set.add("ee");set.add("aa");
		System.out.println(set);
		
		Set<Student> set2 = new HashSet<Student>();
		Student s1 = new Student("ws", 10);Student s2 = new Student("lw", 20);Student s3 = new Student("hq", 19);
		Student s4 = new Student("ws", 18);Student s5 = new Student("ws", 20);Student s6 = new Student("ws", 10);
		set2.add(s1);set2.add(s2);set2.add(s3);set2.add(s4);set2.add(s5);set2.add(s6);
		for (Student s : set2) {
			System.out.println(s.getName());
		}
	}
}
class Student {

	public Student(String name, int age) {
		super();
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
//	@Override
//	public int hashCode() {
//		return name.hashCode() + age * 15;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Student)) {
//			return false;
//		}
//		Student stu = (Student)obj;
//		return name.equals(stu.name) && age == stu.age;
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}





