import java.io.*;
public class test
{
	public static void main(String[] args)
	{
		File file=new File("D:/pal5");
		System.out.println(file.getName());
		f(file,1);
	}
	private static void f(File file,int level)
	{
		String aa="";
		for (int i=0;i<level ;i++ ) {
			aa+="	";
		}
		File[] childs=file.listFiles();
		for (int i=0;i < childs.length ;i++ ) {
			
			if (!childs[i].isDirectory()) 
				System.out.println(aa+childs[i].getName());
			else
			{
				System.out.println(aa+childs[i].getName());
				f(childs[i],level+1);
			}
		}
	}
}