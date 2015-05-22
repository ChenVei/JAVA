import java.io.*;
public class test
{
	public static void main(String[] args)
	{
		File f=new File("new.txt");
		FileInputStream fis;
		FileOutputStream fos;
		byte[] a,b,buf;
		a="Happy Birthday to you~".getBytes();
		b="新年快乐".getBytes();
		buf=new byte[100];
		int n=-1;
		try{
			fos=new FileOutputStream(f); //default append is true;
			fos.write(a);
			System.out.println(f.getName()+"'s Length:"+f.length());

			fos.close();
			fos=new FileOutputStream(f,false);
			fos.write(b,0,b.length);
			System.out.println(f.getName()+"'s Length:"+f.length());

			fis=new FileInputStream(f);
			while((n=fis.read(buf,0,100))!=-1) {
				String s=new String(buf,0,n);
				System.out.print(s);
			}
			fis.close(); //pay attention!
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
