import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class xtest {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			Class c = arr.getClass();
			Method m = c.getMethod("add", Object.class);
			m.invoke(arr, "xxx");
			m.invoke(arr, "xxx");
			m.invoke(arr, "xxx");
			arr.add(15);
			System.out.println(arr);

			Integer x1 = arr.get(3);
			System.out.println(x1);

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
