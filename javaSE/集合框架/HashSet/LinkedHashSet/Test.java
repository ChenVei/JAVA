import java.util.LinkedHashSet;

public class Test {
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();  //���򣬲��ظ�
		lhs.add("Hello");lhs.add("Java");lhs.add("Hello");lhs.add("World!");
		System.out.println(lhs);
	}
}
