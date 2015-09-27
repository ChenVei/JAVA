package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {
	public static void main(String[] args) {
		final Business b = new Business();
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					b.sub(i);
				}
			}
		}.start();

		for (int i = 0; i < 50; i++) {
			b.main(i);
		}
	}

	static class Business {
		boolean sub = true;
		Lock k = new ReentrantLock();
		Condition con = k.newCondition();

		void sub(int i) {
			k.lock();
			try {
				while (!sub) {
					con.await();
				}
				for (int j = 0; j < 10; j++) {
					System.out.println("sub inner:" + j + " outer:" + i);
				}
				sub = false;
				con.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				k.unlock();
			}
		}

		void main(int i) {
			k.lock();
			try {
				while (sub) {
					con.await();
				}
				for (int j = 0; j < 5; j++) {
					System.out.println("main inner:" + j + " outer:" + i);
				}
				sub = true;
				con.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				k.unlock();
			}
		}
	}
}
