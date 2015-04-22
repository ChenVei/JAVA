
public class test
{

	public static void main(String[] args)
	{
		
		Runner1 rr=new Runner1();
		rr.start();
		try{Thread.sleep(10000);}
		catch(InterruptedException e){}
		rr.interrupt();  //simple but rude
	}
}
class Runner1 extends Thread
{
	public void run()
	{
		int i=0;
		while(true)
		{
			System.out.println("Hello~"+i++);
			try{sleep(1000);}
			catch(InterruptedException e)
			{System.out.println("I was Interrupted!!");return;}
		}
		
	}
}