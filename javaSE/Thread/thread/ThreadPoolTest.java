package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);
//		ExecutorService threadPool = Executors.newCachedThreadPool();
		ExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
		
		for (int i = 0; i < 10; i++) {
			final int t = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						System.out.println(Thread.currentThread().getName()
								+ "inner:" + j + "--outer:"+ t);
					}
				}
			});
		}
		
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing...");
			}
		}, 3, TimeUnit.SECONDS);
		
//		threadPool.shutdown();  //no new tasks will be accepted
//		threadPool.shutdownNow(); //halts the processing of waiting tasks
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
	}
}
