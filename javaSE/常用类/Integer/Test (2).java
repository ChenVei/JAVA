
public class Test {
	public static void main(String[] args) {
		Integer in = new Integer(1560), in2 = new Integer(100);
		
		System.out.println(in.byteValue());
		System.out.println(in.compareTo(in2));
		System.out.println(Integer.decode("123456"));
		System.out.println(in.doubleValue());
		System.out.println(Integer.toHexString(25435386));
		
		System.out.println(in.hashCode());
	}
}
