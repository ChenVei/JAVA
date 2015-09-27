package tEST;

import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class jTest {

	@Test
	public void testRead() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/students.xml");
		Element root = document.getRootElement();
		List<Element> list = root.elements();
		for (Iterator<Element> iterator = list.iterator(); iterator.hasNext();) {
			Element element = iterator.next();
			System.out.println(element.getName());
			System.out.println(element.attributeValue("name"));
		}
	}

	@Test
	public void testWrite() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/students.xml");

		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter( new FileWriter("src/students.xml"), format );
		
		document.getRootElement().addElement("不转不是").setText("中国人");
		
		Element e = document.getRootElement().element("student");
		Element ea = DocumentHelper.createElement("cool");
		ea.setText("dog");
		e.add(ea);
		
		writer.write(document);
		writer.close();
	}
	
	@Test
	public void testXpath() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/students.xml");
		
		String name = "aa";
		String id = "2";
		Node n = document.selectSingleNode("//student[@name='"+name+"' and @id='"+id+"']");
		if (n!=null) {
			System.out.println("log on...");
		}
	}
	
}
