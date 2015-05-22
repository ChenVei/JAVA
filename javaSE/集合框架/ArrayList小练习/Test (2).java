import java.util.ArrayList;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < 10; ) {
			int k = r.nextInt(20)+1;
			if (arr.contains(k)) {
				continue;
			}
			else {
				i++;
				arr.add(k);
			}
		}
		System.out.println(arr);
	}
}