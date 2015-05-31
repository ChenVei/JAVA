import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class xtest {

	public static void main(String[] args) {
		Tool tool = new Tool();
		XXX p = new XXX();
		tool.setProperty(p, "name", "ws");
		tool.setProperty(p, "age", 19);
		
		System.out.println(p);
	}
}

class XXX {
	private String name;
	int age;
	
	@Override
	public String toString() {
		return name + "---" + age;
	}
}