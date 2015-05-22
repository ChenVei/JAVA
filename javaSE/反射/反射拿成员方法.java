package reflect3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflect0.Person");
		
		//Method[] methods = c.getMethods();  //获取自己的包括父类的公共方法
		Method[] methods = c.getDeclaredMethods();  //获取自己的所有方法
		for (Method method : methods) {
			System.out.println(method);
		}
		
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		
		//获取单个方法
		Method m1 = c.getMethod("show");
		m1.invoke(obj);
		
		Method m2 = c.getMethod("method", String.class);
		m2.invoke(obj, " Hello~");
		
		Method m3 = c.getMethod("getString", String.class, int.class);
		Object objString = m3.invoke(obj, "ws", 19);
		System.out.println(objString);
		
		Method m4 = c.getDeclaredMethod("function");
		m4.setAccessible(true);
		m4.invoke(obj);
	}
}
