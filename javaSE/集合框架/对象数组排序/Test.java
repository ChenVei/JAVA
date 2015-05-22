public class Test {

	public static void main(String[] args) {
		Student[] students = new Student[5];
		Student s1 = new Student("ww",15);
		Student s2 = new Student("ws",19 );
		Student s3 = new Student("lw",20 );
		Student s4 = new Student("sg",21 );
		Student s5 = new Student("hq",7 );students[0]=s1;students[1]=s2;students[2]=s3;students[3]=s4;students[4]=s5;
		System.out.println("Before:");
		for (Student student : students) {
			System.out.println(student);
		}
		sort(students);
		System.out.println("After:");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static void sort(Student[] students) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < students.length-1; i++) {
			for (int j = 0; j < students.length-i-1; j++) {
				if (students[j].getAge()<students[j+1].getAge()) {
					Student t;
					t=students[j];
					students[j]=students[j+1];
					students[j+1]=t;
				}
				
			}
		}
	}
}

class Student {
	private int age;
	private String name;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}

}