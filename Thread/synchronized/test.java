class Test implements Runnable
{
	Timer timer=new Timer();
	public static void main(String[] args)
	{
		Test t=new Test();
		Thread r1=new Thread(t),r2=new Thread(t);
		r1.start();r2.start();
	}
	public void run()
	{
		timer.add(Thread.currentThread());
	}
}
class Timer{
	synchronized void add(String s)
	{
		for (int i=0;i<1000 ;i++ ) {
			System.out.println(s+":"+i);
		}
	}
}