import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(map.put("wenzhang", "mayili"));
		System.out.println(map.put("wenzhang", "yaodi"));
		
		map.put("huangxiaoming", "AB");
		map.put("liukaiwei", "yangmi");
		map.put("erkang", "ziwei");
		//map.clear();
		System.out.println(map.remove("huangxiaoming"));
		System.out.println(map.containsKey("liukaiwei"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println(map);
		
		System.out.println("-------------");
		System.out.println("get:"+map.get("erkang"));
		
		Set<String> set = map.keySet();  //Key is unique, so Set;
		for (String s : set) {
			System.out.print(s+" ");
		}
		System.out.println();
		Collection<String> coll = map.values();  //and value can be repeated
		for (String s : coll) {
			System.out.print(s+" ");
		}
		
		System.out.println("\n-------------");
		set = map.keySet();
		for (String s : set) {
			String val = map.get(s);
			System.out.println(s+"------"+val);
		}
		
		System.out.println("-------------");
		Set<Entry<String, String>> set1 = map.entrySet();
		for (Entry<String, String> entry : set1) {
			System.out.println(entry.getKey()+"------"+entry.getValue());
		}
 	}
}














