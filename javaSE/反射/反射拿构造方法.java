package reflect1;

import java.lang.reflect.Constructor;

public class ReflectDemp {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflect0.Person");
		// Constructor[] cons = c.getConstructors(); //类的 所有 公共构造方法。
		Constructor[] cons = c.getDeclaredConstructors(); // 类 声明的 所有构造方法

		for (Constructor con : cons) {
			System.out.println(con);
		}
		
		/*
		 * Constructor con = c.getConstructor(); //无参构造器
		 * Object obj = con.newInstance();
		 * System.out.println(obj);
		 */

		Constructor con = c.getDeclaredConstructor(String.class, int.class);
		con.setAccessible(true); // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查
		Object p = con.newInstance("xxx", 15);
		System.out.println(p);
	}
}
