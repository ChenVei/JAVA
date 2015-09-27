package tEST;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


public class jTest {

	@Test
	public void test() throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		XMLReader xr = sp.getXMLReader();
		// xr.setContentHandler(new ListHandler());
		BeanListHandler blh = new BeanListHandler();
		xr.setContentHandler(blh);
		xr.parse("src/students.xml");
		
		List<Student> l = blh.getList();
		for (Student student : l) {
			System.out.println(student);
		}
	}
}

class BeanListHandler extends DefaultHandler {
	private List<Student> list = new ArrayList<>();
	private Student s;
	private String currStr;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currStr = qName;
		if ("student".equals(qName)) {
			s = new Student();
			s.setName(attributes.getValue("name"));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		currStr = null;
		if ("student".equals(qName)) {
			list.add(s);
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if ("age".equals(currStr)) {
			int age = Integer.parseInt(new String(ch, start, length));
			s.setAge(age);
		} else if ("sex".equals(currStr)) {
			s.setSex(new String(ch, start, length));
		} else if ("grade".equals(currStr)) {
			int grade = Integer.parseInt(new String(ch, start, length));
			s.setGrade(grade);
		}
	}

	public List<Student> getList() {
		return list;
	}

}

class ListHandler implements ContentHandler {
	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		System.out.println("<" + qName + ">");
		for (int i = 0; atts != null && i < atts.getLength(); i++) {
			System.out.println(atts.getQName(i));
			System.out.println(atts.getValue(i));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("</" + qName + ">");

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println(new String(ch, start, length));
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

}