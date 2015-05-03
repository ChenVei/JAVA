import static java.lang.Math.abs;  //静态导入

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println(abs(-5500));  
		System.out.println(f(10,20,30));
		System.out.println(f(1,2,3,4,5,6,7,8,9));
		
		String str[] = {"hello","nihao","holeidai","JQlai"};
		List<String> li = Arrays.asList(str);
		for (String s : li) {
			System.out.println(s);
		}
//		li.add("xxx");
//		LI.REMOVE(1);
		li.set(2, "xxx");
	}

	private static int f(int... arr) {  //可变参数必须位于最后
		int k=0;
		for (int i : arr) {
			k+=i;
		}
		return k;
	}
}