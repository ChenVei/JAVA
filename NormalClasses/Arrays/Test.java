import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] a = {25,12,63,21,-8,5,-99,42,13};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.println(Arrays.binarySearch(a, 42));
		System.out.println(Arrays.binarySearch(a, 64));
	}
}


