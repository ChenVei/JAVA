import java.io.*;
import java.util.regex.*;
public class test
{

	public static void main(String[] args)
	{
		File f=new File("d:/java");	
		System.out.println(f.getName()+" "+f.canRead());
		System.out.println(f.length());
		System.out.println(f.getAbsolutePath());
		f = new File("new.txt");
		System.out.println("Creat new file in current directory;");
		if (!f.exists()) {
			try{
				f.createNewFile();  //in sourse file.like test.java
			}
			catch(IOException e){System.out.println("SUCCESS.");}
		}
	}
}