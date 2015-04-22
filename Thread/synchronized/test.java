class Test implements Runnable
{
	Timer timer=new Timer();
	public static void main(String[] args)
	{
		Test test=new Test();
		Thread t1=new Thread(test);
		Thread t2=new Thread(test);
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();
	}
	public void run()
	{
		timer.add(Thread.currentThread().getName());
	}
}
class Timer{
	static int n;
	public synchronized void add(String s)  //current object is locked
	{
		n++;
		try{Thread.sleep(1);}  
		catch(InterruptedException e){e.printStackTrace();}
		System.out.println(s+":"+n);		
		
	}
}