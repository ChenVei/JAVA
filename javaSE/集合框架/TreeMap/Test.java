import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		TreeMap<String, String> tmap = new TreeMap<String, String>();

		tmap.put("ws", "1111");
		tmap.put("lw", "2222");
		tmap.put("hq", "3333");
		tmap.put("pz", "4444");
		tmap.put("ws", "5555");
		Set<String> set = tmap.keySet();
		for (String k : set) {
			System.out.println(k + "-------" + tmap.get(k));
		}
		
		System.out.println("-------------------");
		TreeMap<Student, String> tmap2 = new TreeMap<Student, String>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				return s1.getAge() - s2.getAge();
			}
		});
		Student s1 = new Student("lw", 12), s2 = new Student("ws", 13), s3 = new Student(
				"hq", 14), s4 = new Student("pz", 15), s5 = new Student("ws",
				13);

		tmap2.put(s1, "1111");
		tmap2.put(s2, "2222");
		tmap2.put(s3, "3333");
		tmap2.put(s4, "4444");
		tmap2.put(s5, "5555");
		
		Set<Student> set2 = tmap2.keySet();
		for (Student k : set2) {
			System.out.println(k + "-------" + tmap2.get(k));
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

}