class Test implements Runnable
{
	int flag;
	static Object o1=new Object(),o2=new Object();
	Test(int flag)
	{this.flag=flag;}
	public void run()
	{
		System.out.println("flag:"+flag);
		if (flag==0) {
			synchronized(o1){	
				try{Thread.sleep(500);}
				catch(InterruptedException e){}
			synchronized(o2){System.out.println("0");}
			}
		}
		if (flag==1) {
			synchronized(o2){
				try{Thread.sleep(500);}
				catch(InterruptedException e){}
			synchronized(o1){System.out.println("1");}
			}
		}
	}
	public static void main(String[] args)
	{
		Thread t1=new Thread(new Test(0));
		Thread t2=new Thread(new Test(1));
		t1.start();
		t2.start();
	}
	
}
