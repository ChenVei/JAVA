import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("hello");c.add("Bye");c.add("WHat");c.add("hoha");c.add("Bye");
//		c.clear();
		c.remove("Bye");c.remove("wye");
		System.out.println(c.contains("hoha"));
		System.out.println("c:"+c+" Length:"+c.size());
		c.clear();  //empty
		
		Collection c1 = new ArrayList();
		for (int i = 0; i < 4; i++) c.add("abc"+i);
		for (int i = 3; i < 7; i++) c1.add("abc"+i);
		System.out.println("----------");
		System.out.println(c);
		System.out.println(c1);
		
//		System.out.println(c.addAll(c1));  //求并集  会对原集合产生影响
//		System.out.println(c);
		
//		System.out.println(c.removeAll(c1));  //求差集
//		System.out.println(c);
		
//		System.out.println(c.retainAll(c1));  //求交集
//		System.out.println(c+"\n"+c1);
		
		Object[] objs = c1.toArray();  //两种遍历
		for (int i = 0; i < objs.length; i++) {
			String s = (String)objs[i];
			System.out.println(s+"---"+s.length());
		}
		
		Iterator it = c1.iterator();
		while (it.hasNext()) {
			String s = (String)it.next();
			System.out.println(s);
		}
	}
}