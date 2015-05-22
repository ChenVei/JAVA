import java.io.*;
import java.util.regex.*;
public class test
{
	public static void main(String[] args)
	{	
		//p("asd1fs2-5@126.com".matches("[\\w[-.]]+@[\\w[-.]]+\\.[\\w[-.]]+"));
		Pattern p=Pattern.compile("\\d{3,5}");
		String s="123-34345-234-00";
		Matcher m=p.matcher(s);
		p(m.matches());  //matches与find相互影响
		m.reset();  //what you eat spit out
		p(m.find());

		p(m.start()+" "+m.end()); //only when you find can you output
		p(m.find());
		p(m.find());
		p(m.find());
		p(m.lookingAt());  //seek from head

		p=Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		s="java JaVA JAva jAvA I loveJaVA,you hateJava  testing``testing";
		m=p.matcher(s); 
		while(m.find())
		{
			p(m.group());
		}
		p(m.replaceAll("JAVA")); //the method returns a string, and do nothing with previous matcher

		m.reset();
		int i=0;
		StringBuffer buf=new StringBuffer();
		while(m.find())
		{
			if(i%2==0)
				m.appendReplacement(buf,"java");
			else m.appendReplacement(buf,"JAVA");
			i++;
		}
		m.appendTail(buf);  //
		p(buf);
	}
	public static void p(Object o)
	{
		System.out.println(o);
	}
}