import java.util.LinkedHashMap;
import java.util.Set;


public class Test {
	public static void main(String[] args) {
		LinkedHashMap<String, String> lhmap = new LinkedHashMap<String, String>(); 
		
		lhmap.put("ws","1111");
		lhmap.put("lw","2222");
		lhmap.put("hq","3333");
		lhmap.put("pz","4444");
		lhmap.put("sg","5555");
		Set<String> set = lhmap.keySet();
		for (String k : set) {
			System.out.println(k+"-------"+lhmap.get(k));
		}
	}
}
	