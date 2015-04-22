
public class test
{
	public static void main(String[] args)
	{
		Thread t1=new Thread(new T1());
		Thread t2=new Thread(new T2());
		t1.setPriority(Thread.NORM_PRIORITY+5);
		t2.setPriority(Thread.NORM_PRIORITY-4);
		t1.start();t2.start();
	}
}
class T1 implements Runnable
{
	public void run()
	{
		for (int i=0;i<10000 ;i++ ) {
			System.out.println("T1:"+i);
		}
	}
}
class T2 implements Runnable
{
	public void run()
	{
		for (int i=0;i<10000 ;i++ ) {
			System.out.println("T2:"+i);
		}
	}
}