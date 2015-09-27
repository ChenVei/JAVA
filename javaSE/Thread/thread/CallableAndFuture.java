package thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableAndFuture {
	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> f = es.submit(new Callable<String>() { // once submit, it
																// will
																// execute..
					@Override
					public String call() throws Exception {
						for (int i = 0; i < 100; i++) {
							System.out.println("c2:" + i);
						}
						Thread.sleep(3000);
						return "yes";
					}

				});
		for (int i = 0; i < 100; i++) {
			System.out.println("c1:" + i);
		}
		try {
			String s = f.get(2, TimeUnit.SECONDS); // get the result then go
													// on...or throw
													// TimeOutException
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
		for (int i = 0; i < 10; i++) {
			final int k = i;
			cs.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(2000));
					return k;
				}
			});
		}
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(cs.take().get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
