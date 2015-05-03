import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		for (int i = 1; i < 5; i++) {
			li.add("aab"+i);
		}
		li.add(1,"haleeo");  //from zero
		
		
		for (Iterator<String> it = li.iterator(); it.hasNext();) {
			
			System.out.println(it.next());
			
		}
		System.out.println("---------------------");
		System.out.println(li.remove(4)+" WAS REMOVED");
		System.out.println("GET SECOND:"+li.get(2));
		System.out.println("set:"+li.set(0, "HUlala"));
		System.out.println("---------------------");
		for (int i = 0; i < li.size(); i++) {
			String s = (String)li.get(i);
			System.out.println(s);
		}
//		Iterator it2 = li.iterator();
//		for (; it2.hasNext();) {
//			String s = (String)it2.next();
//			if (s.equals("aab3")) {
//				li.add("xxxxxx");  //May trigger "ConcurrentModificationException"
//			}
//		}
		
		ListIterator<String> it = li.listIterator();
		for (; it.hasNext();) {
			String s = (String)it.next();
			if (s.equals("aab3")) {
				it.add("xxxxxx");
			}
		}
		System.out.println(li);
		while (it.hasPrevious()) {
			String s = (String)it.previous();
			System.out.println(s);
		}
		
		for (String s : li) {  //ÔöÇ¿for
			System.out.println(s);
		}
	}
}













