
public class test
{

	public static void main(String[] args)
	{
		/*
		Runner1 r=new Runner1("Biubiu");
		r.start();
		try{
			r.join();  //combined in the main thread.And it has effects on yield();
		}
		catch(InterruptedException e){System.out.println("I was Interrupted!!");}
*/
		for (int i=0;i<10 ;i++ ) {
			System.out.print(i);
		}
		System.out.println();
		Runner2 r1,r2;
		r1=new Runner2("r1:");
		r2=new Runner2("r2:");
		r1.start();
		r2.start();
	}
}
class Runner1 extends Thread
{
	Runner1(String s){
		super(s);
	}
	public void run()
	{
		int i=1;
		while(i<3)
		{
			System.out.println(getName()+i++);
			try{sleep(1000);}
			catch(InterruptedException e)
			{System.out.println("I was Interrupted!!");return;}
		}
	}
}
class Runner2 extends Runner1
{
	Runner2(String s){
		super(s);
	}
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(getName()+i);
			if (i%10==0) {
				yield();
			}
		}
	}
}