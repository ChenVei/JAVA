package thread;

/**
 * test wait and notify
 * @author Administrator
 *
 */
public class NotifyTest {  
    private String flag = "true";  
  
    class NotifyThread extends Thread{  
        public NotifyThread(String name) {  
            super(name);  
        }  
        public void run() {       
            try {  
                sleep(1000);
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
  //flag = "false";   //do not operate the lock while existing other threads who waits for it..
                synchronized (flag) {
					flag.notifyAll();
				}  
        }  
    }
  
    class WaitThread extends Thread {  
        public WaitThread(String name) {  
            super(name);  
        }  
  
        public void run() {     
                synchronized (flag) {
					while (flag != "false") {
						long waitTime = System.currentTimeMillis();
						try {
							System.out.println(getName() + " begin waiting!");
							flag.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						waitTime = System.currentTimeMillis() - waitTime;
						System.out.println("wait time :" + waitTime);
					}
					System.out.println(getName() + " end waiting!");
				}  
        }  
    }

    public static void main(String[] args) throws InterruptedException {  
        System.out.println("Main Thread Run!");  
        NotifyTest test = new NotifyTest();  

        NotifyThread notifyThread = test.new NotifyThread("notify01"); 
 
        WaitThread waitThread01 = test.new WaitThread("waiter01");  
        WaitThread waitThread02 = test.new WaitThread("waiter02");  
        WaitThread waitThread03 = test.new WaitThread("waiter03");  

        notifyThread.start();  

        waitThread01.start();  
        waitThread02.start();  
        waitThread03.start();  
    }  
}  