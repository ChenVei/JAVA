import java.io.*;
import java.util.regex.*;
public class test
{

	public static void main(String[] args)
	{	
		Pattern p=Pattern.compile("(.{3,10}?)[0-9]"); //?-reluctant null-greedy +-possessive
		String s="aaaa5bbbb6";
		Matcher m=p.matcher(s);
		if (m.find()) {
			p(m.start() + "-" + m.end());
		}else p("Not match!");

		//p=Pattern.compile(".{3}(?=a)");
		p=Pattern.compile("(?!a).{3}");
		s="444a556";
		m=p.matcher(s);
		while(m.find())
			p(m.group());
	}
	public static void p(Object o)
	{
		System.out.println(o);
	}
}