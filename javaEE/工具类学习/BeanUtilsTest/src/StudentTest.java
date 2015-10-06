import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;


public class StudentTest {

	@Test
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class s = Class.forName("Student");
		Student stu = (Student) s.newInstance();
		BeanUtils.setProperty(stu, "name", "ws");
		System.out.println(stu);
	}
	
	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException {
		Student s = new Student();
		//use its own dateConverter
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(s, "age", 20);
		BeanUtils.setProperty(s, "birth", "1995-8-26");
		System.out.println(s);
	}
	
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException {
		Student s = new Student();
		ConvertUtils.register(new Converter() {
			
			@Override
			public <T> T convert(Class<T> type, Object value) {
				if (value == null) {
					return null;
				}
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
				Date d = null;
				try {
					d = s.parse((String)value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				return (T) d;
			}
		}, Date.class);
		BeanUtils.setProperty(s, "age", 20);
		BeanUtils.setProperty(s, "birth", "1995-8-26");
		System.out.println(s);
	}

}
