package thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Queue q = new Queue();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						q.read();
					}
				}
			}).start();
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						q.write(new Random().nextInt(100));
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}

	static class Queue {
		Object data;
		ReadWriteLock rwl = new ReentrantReadWriteLock();

		public void read() {
			try {
				rwl.readLock().lock(); // assume the thread is for reading, and
										// another thread's same method can
										// execute concurrently...
				System.out.println(Thread.currentThread().getName()
						+ " begin to read..");
				System.out.println(Thread.currentThread().getName()
						+ " have read the data:" + data);
			} finally {
				rwl.readLock().unlock();
			}
		}

		public void write(Object d) {
			try {
				rwl.writeLock().lock();
				System.out.println(Thread.currentThread().getName()
						+ " begin to write..");
				data = d;
				System.out.println(Thread.currentThread().getName()
						+ " have write the data:" + data);
			} finally {
				rwl.writeLock().unlock();
			}
		}
	}
}
