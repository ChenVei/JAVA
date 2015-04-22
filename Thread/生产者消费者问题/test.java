class test
{
	public static void main(String[] args)
	{
		SyncStack ss=new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(c).start();
	}
	
}
class WoTou
{
	int id;
	WoTou(int id){this.id=id;}
	public String toString()
	{
		return "wotou:"+id;
	}
}
class SyncStack
{
	int index = 0;
	WoTou[] arrWT=new WoTou[6];

	public synchronized void push(WoTou wt)
	{
		if (index == arrWT.length) {
			try{this.wait();}  				//the method must be synchronized
			catch(InterruptedException e)   //and it released its lock
			{e.printStackTrace();}
		}
		this.notify(); //wakeup one who is waiting
		arrWT[index]=wt;
		index++;
	}
	public synchronized WoTou pop()
	{
		if (index == 0) {
			try{this.wait();}  				
			catch(InterruptedException e)   
			{e.printStackTrace();}
		}
		this.notify(); 
		index--;
		return arrWT[index];
	}
}
class Producer implements Runnable
{
	SyncStack ss = null;
	Producer(SyncStack ss)
	{this.ss = ss;}
	public void run()
	{
		for (int i=0; i<20 ; i++) {
			WoTou wt=new WoTou(i);
			ss.push(wt);
			System.out.println("Produce:"+wt);
			try{Thread.sleep((long)(Math.random()*1000));}
			catch(InterruptedException e){e.printStackTrace();}
		}
	}
}
class Consumer implements Runnable
{
	SyncStack ss = null;
	Consumer(SyncStack ss)
	{this.ss = ss;}
	public void run()
	{
		for (int i=0; i<20 ; i++) {
			WoTou wt=new WoTou(i);
			System.out.println("Consume:"+ss.pop());
			try{Thread.sleep(2000);}
			catch(InterruptedException e){e.printStackTrace();}
		}
	}
}