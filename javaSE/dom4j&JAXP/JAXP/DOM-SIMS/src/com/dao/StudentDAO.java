package com.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.domain.Student;
import com.utils.DB;

public class StudentDAO {
	static Document d = DB.readXML();
	
	public static void save(Student u) {
		Element e = d.createElement("student");
		e.setAttribute("name", u.getName());
		
		Element age = d.createElement("age");
		age.setTextContent(""+u.getAge());
		e.appendChild(age);
		
		Element sex = d.createElement("sex");
		sex.setTextContent(""+u.getSex());
		e.appendChild(sex);
		
		Element grade = d.createElement("grade");
		grade.setTextContent(""+u.getGrade());
		e.appendChild(grade);
		
		Node n = d.getLastChild();
		n.appendChild(e);		
		DB.updateXML(d);
	}
	
	public static boolean delete(String name) {
		boolean ok = false;
		NodeList nl = d.getElementsByTagName("student");
		for(int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			if (n instanceof Element) {
				Element e = (Element)n;
				if (name.equals(e.getAttribute("name"))) {
					e.getParentNode().removeChild(e);
					ok = true;
					break;
				}
			}
		}
		DB.updateXML(d);
		return ok;
	}

	public static Student find(String name) {
		NodeList nl = d.getElementsByTagName("student");
		for(int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			if (n instanceof Element) {
				Element e = (Element)n;
				if (name.equals(e.getAttribute("name"))) {
					Node age = DB.getNode(e, "age");
					Node sex = DB.getNode(e, "sex");
					Node grade = DB.getNode(e, "grade");
					return new Student(name, Integer.parseInt(age.getTextContent()), sex.getTextContent(), Integer.parseInt(grade.getTextContent()));
				}
			}
		}
		return null;
	}
}
