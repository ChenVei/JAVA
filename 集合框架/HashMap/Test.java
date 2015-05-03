import java.util.HashMap;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		HashMap<Student, String> hmap = new HashMap<Student, String>(); 
		Student s1 = new Student("lw",12),s2 = new Student("ws",13),s3 = new Student("hq",14),s4 = new Student("pz",15),s5 = new Student("ws",13);
		
		hmap.put(s1,"1111");
		hmap.put(s2,"2222");
		hmap.put(s3,"3333");
		hmap.put(s4,"4444");
		hmap.put(s5,"5555");
		Set<Student> set = hmap.keySet();
		for (Student k : set) {
			System.out.println(k+"-------"+hmap.get(k));
		}
	}
}
class Student {
	/**
	 * @param name
	 * @param age
	 */
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
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
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