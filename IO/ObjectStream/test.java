import java.io.*;
import java.util.*;
public class test
{
	public static void main(String[] args)
	{	
		T t=new T();
		try
		{
			FileOutputStream fos=new FileOutputStream("d:/java/xxx.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(t);
			oos.flush();
			oos.close();

			FileInputStream fis=new FileInputStream("d:/java/xxx.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			T read=(T)ois.readObject();
			System.out.println(read);
			ois.close();
		}
		catch(IOException e)
		{e.printStackTrace();}
		catch(ClassNotFoundException e)
		{e.printStackTrace();}

	}
	public static void p(Object o)
	{
		System.out.println(o);
	}
}
class T
implements Serializable
{
	int a=4;
	int b=5;
	int c=6;
	transient double d=7.6;
	public String toString()
	{return (a+" "+b+" "+c+" "+d);}
}