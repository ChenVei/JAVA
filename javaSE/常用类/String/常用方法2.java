import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String s = "Hello World";
		String s2 = "ƒ„∫√ ¿ΩÁ";
		byte[] b =s.getBytes();
		System.out.println(Arrays.toString(b));
		System.out.println(b+"   "+b.hashCode());  //16 10
		
		char[] ch = {'a','b','c','d','e','f'};
		s2.getChars(0, 4, ch, 1); //replace
		System.out.println(ch);
		
		String s3 = s.replace('o', 'z');
		System.out.println(s3);
		
		ch = s3.toCharArray();
		System.out.println(ch);
		
		s3 = "   xxx  xxx  xxxxxx     ";
		System.out.println(s3.trim()+"----"+s3);
		
		System.out.println(String.valueOf(ch));
	}
}
