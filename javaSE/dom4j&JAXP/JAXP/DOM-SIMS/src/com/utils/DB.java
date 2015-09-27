package com.utils;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DB {
	public static Document readXML() {
		Document d = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			d = db.parse("src/students.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	public static void updateXML(Document d) {
		TransformerFactory tff = TransformerFactory.newInstance();  //write back;
		try {
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(d), new StreamResult(new FileOutputStream("src/students.xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Node getNode(Element e, String name)	 {
		return e.getElementsByTagName(name).item(0);
	}
}
