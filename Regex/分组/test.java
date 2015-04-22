import java.io.*;
import java.util.regex.*;
public class test
{
	public static void main(String[] args)
	{	
		Pattern p=Pattern.compile("(\\d{3,5})([a-z]{2})");  //group by null,1,2,...
		String s="123aa-35345bb-234cc-00";
		Matcher m=p.matcher(s);
		while(m.find())
		{
			p(m.group(2)); //print out what has matched! Parameter:null is full,1 is groupOne
		}
	}
	public static void p(Object o)
	{
		System.out.println(o);
	}
}