import java.io.*;
import java.util.regex.*;
public class test
{
	public static void main(String[] args)
	{	
		try{
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\test\\xx.htm"));
			String line="";
			while((line=br.readLine())!=null)
			{
				parse(line);
			}
		}
		catch(FileNotFoundException e)
		{e.printStackTrace();}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void parse(String line)
	{
		Pattern p=Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.\\w+");
		Matcher m=p.matcher(line);
		while(m.find())
		{
			System.out.println(m.group());
		}
	}
}