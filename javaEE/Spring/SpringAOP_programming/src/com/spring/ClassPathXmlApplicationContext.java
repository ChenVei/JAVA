package com.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.spring.BeanFactory;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Object> beans = new HashMap<String, Object>();

	// IOC Inverse of Control DI Dependency Injection
	public ClassPathXmlApplicationContext() throws Exception {
		SAXReader sb = new SAXReader();

		Document doc = sb.read(this.getClass().getClassLoader()
				.getResource("beans.xml"));
		Element root = doc.getRootElement();
		List list = root.elements("bean");
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element) list.get(i);

			String id = element.attributeValue("id");
			String clazz = element.attributeValue("class");
			Object o = Class.forName(clazz).newInstance(); //userService

			System.out.println(id);
			System.out.println(clazz);
			beans.put(id, o);

			for (Element ele : (List<Element>) element.elements("property")) {
				String name = ele.attributeValue("name");	//userDAO
				String bean = ele.attributeValue("bean");	//u
				Object obj = beans.get(bean);				//u->UserDAOImpl
				String method = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
															//setUserDAO
				
				Method m = o.getClass().getDeclaredMethod(method, obj.getClass().getInterfaces()[0]);
				m.invoke(o, obj);
			}
		}
	}

	@Override
	public Object getBean(String id) {
		return beans.get(id);
	}
}
