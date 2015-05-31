import java.lang.reflect.Field;

public class Tool {
	public void setProperty(Object obj, String name, Object value) {
		Class c = obj.getClass();
		try {
			Field field = c.getDeclaredField(name);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
