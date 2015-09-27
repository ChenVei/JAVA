package thread;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareDate {
	
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					threadData.put(Thread.currentThread(), data);
					System.out.println(Thread.currentThread().getName()
						+" ---- "	+ data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();
	private static int data = 0;

	static class A {
		void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName()
					+" ---- "	+ data);
		}
	}

	static class B {
		void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName()
					+" ---- "+ data);
		}
	}
}
