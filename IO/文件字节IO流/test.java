import java.io.*;
public class test
{
	public static void main(String[] args)
	{
		int num=0,b;
		FileInputStream in=null;
		FileOutputStream out=null;
		try{
			in=new FileInputStream("D:/java/test.java");
			out=new FileOutputStream("D:/java/TTT.java");
		
			while((b=in.read())!=-1)  //what he reads out is int
			{
				System.out.print((char)b);
				num++;

				out.write(b);
			}		
			System.out.println("read total "+num+" nums.And copy successfully.");
			in.close();
			out.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
		catch(IOException e)
		{
			System.out.println("Read Error!");
		}

	}
}
