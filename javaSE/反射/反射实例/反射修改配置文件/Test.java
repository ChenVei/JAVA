import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;


public class Test {

	public static void main(String[] args) throws Exception {
	
		Properties prop = new Properties();
		FileReader fr = new FileReader("class.txt");
		prop.load(fr);
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");
		
		Class c = Class.forName(className);
		
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		
		Method m = c.getMethod(methodName);
		m.invoke(obj);
	}

}
