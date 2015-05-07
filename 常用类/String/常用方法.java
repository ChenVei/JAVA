public class Test {
	public static void main(String[] args) {
		byte[] by = {97,98,99,100,101,102,103,127};
		String s1 = new String(by);
		System.out.println(s1);
		
		String s = new String(by,1,5);
		System.out.println(s);
		
		char[] ch = {95,96,97,98,99,100,101,102,425,6554,42545,65535};
		s = new String(ch);
		System.out.println(s);
		
		char c = s.charAt(2);
		System.out.println(c);
		System.out.println(s.codePointAt(9));
		System.out.println(s.codePointBefore(2));
		System.out.println(s.codePointCount(2,5));
		
		s1="abcdef";s="abCdefg";
		System.out.println("-----\n"+s1.compareTo(s));
		System.out.println(s1.compareToIgnoreCase(s));
		
		String s2 = s1.concat(s);
		System.out.println(s1+"   "+s2);
		System.out.println(s2.contains(s1));
		
		s2 = new String("abcdef");
		System.out.println(s2.contentEquals(s1));
		
		System.out.println(String.copyValueOf(ch));
		
	}
}
