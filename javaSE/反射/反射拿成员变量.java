package reflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflect0.Person");
//		Field[] fields = c.getFields();
		Field[] fields = c.getDeclaredFields();
		
		for (Field field : fields) {
			System.out.println(field);
		}
		
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		System.out.println(obj);
		
		Field addressField = c.getField("address");  //获得该字段
		addressField.set(obj, "beijing");
		System.out.println(obj);
		
		Field nameField = c.getDeclaredField("name");
		nameField.setAccessible(true);  //取消访问检查
		nameField.set(obj, "ws");
		System.out.println(obj);
	}
}
