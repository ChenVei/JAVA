import java.io.*;
import java.util.regex.*;
public class test
{

	public static void main(String[] args)
	{
		Thread r=new Thread(new Runner());
		//r.run();  //call method.
		//r.start();
		Runner1 rr=new Runner1();
		rr.start();
		for (int i=0;i < 100 ;i++ ) {
			System.out.print("r1:"+i+"\t");
		}
	}
}
class Runner implements Runnable
{
	public void run()
	{
		for (int i=0;i < 100 ;i++ ) {
			System.out.print("r2:"+i+"\t");
		}
	}
}
class Runner1 extends Thread
{
	public void run()
	{
		for (int i=0;i < 100 ;i++ ) {
			System.out.print("r3:"+i+"\t");
		}
	}
}