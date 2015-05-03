import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> a1= new ArrayList<String>();
		for (int i = 1; i <= 4; i++) a1.add("a"+i);
		ArrayList<String> a2= new ArrayList<String>();
		for (int i = 1; i <= 4; i++) a2.add((char)('a'+i)+"");
		ArrayList<String> a3= new ArrayList<String>();
		a3.add("alloy");a3.add("zoo");a3.add("pig");a3.add("tiger");
		
		ArrayList<ArrayList<String>> BigArr= new ArrayList<ArrayList<String>>();
		BigArr.add(a1);BigArr.add(a2);BigArr.add(a3);
		for (ArrayList<String> a : BigArr) {
			for (String s : a) {
				System.out.println(s);
			}
		}
	}
}