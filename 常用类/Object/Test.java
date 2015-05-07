public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student t = new Student(12, "lw");
		Student m = (Student) t.clone();
		System.out.println(m+"-----"+t);
		
		System.out.println("==?  "+(t.equals(m))+"   "+(t==m));
	}
}

class Student implements Cloneable{
	int age;
	String name;
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO 自动生成的方法存根
		return super.clone();
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
	@Override
	public int hashCode() {
		// TODO 自动生成的方法存根
		return 1;
	}
	
}