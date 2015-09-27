package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) {
		new LockTest().ini();
	}

	public void ini() {
		final OutPut out = new OutPut();
		new Thread() {

			public void run() {
				while (true) {
					out.output("123456789");
				}
			}

		}.start();
		while (true) {
			out.output("abcdefghi");
		}
	}

	class OutPut {
			Lock lock = new ReentrantLock();
		/* synchronized */void output(String s) {
			try {
				lock.lock();
				int len = s.length();
				for (int i = 0; i < len; i++) {
					System.out.print(s.charAt(i));
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
