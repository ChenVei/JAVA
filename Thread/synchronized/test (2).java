class Test implements Runnable
{
	int a=100;
	public synchronized void m()  //it only locks this sentence
	{
		a=1000;
		try{Thread.sleep(3000);}
		catch(InterruptedException e){}  
		System.out.println(a);
	}
	public void run()
	{
		m();
	}
	public synchronized void m1() //when triggered,all locks works
	{
		a-=500;
	}
	public static void main(String[] args)
	{
		Test test=new Test();
		Thread t=new Thread(test);
		t.start();
		try{Thread.sleep(1000);}
		catch(InterruptedException e){}
		test.m1();
		System.out.println(test.a);
	}
	
}
