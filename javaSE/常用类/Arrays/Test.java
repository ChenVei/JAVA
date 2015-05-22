import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] a = {25,12,63,21,-8,5,-99,42,13};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.println(Arrays.binarySearch(a, 5));
		System.out.println(Arrays.binarySearch(a, 4, 6, 5));
		System.out.println(Arrays.binarySearch(a, 64));
		
		int[] b =Arrays.copyOf(a, 4);
		System.out.println(Arrays.toString(b));
		b = Arrays.copyOfRange(a, 1, 5);
		System.out.println(Arrays.toString(b));
		
		System.out.println(Arrays.equals(a, b));
		
		b = new int[10];
		System.out.println(Arrays.toString(b));
		Arrays.fill(b, 4);
		System.out.println(Arrays.toString(b));
		Arrays.fill(b, 2, 5, 0);
		System.out.println(Arrays.toString(b));
		
		System.out.println(b.hashCode());
		
		String[] str = {"Hello", "World", "LOVE", "You"};
		List<String> li = Arrays.asList(str);
		System.out.println(li);
	}
}


