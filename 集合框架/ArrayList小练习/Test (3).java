import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (true) {
			int k = r.nextInt();
			if (k == 0) break;
			arr.add(k);
		}
		Integer[] in = new Integer[arr.size()];
		arr.toArray(in);
		Arrays.sort(in);
		
		System.out.println("------------------");
		for (Integer i : in) {
			System.out.println(i);
		}
	}
}