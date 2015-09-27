package tEST;

public class A {

	public static void main(String args[]) {
		final T t = new T();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					t.sub(i);
				}
			}
		}).start();
		for (int i = 1; i <= 50; i++) {
			t.main(i);
		}
	}

	static class T {
		boolean sharedLock = true;
		public synchronized void sub(int k) {
			if (!sharedLock) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= 10; i++) {
				System.out.println("sub:" + i + " of " + k);
			}
			sharedLock = false;
			this.notify();
		}

		public synchronized void main(int k) {
			if (sharedLock) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= 100; i++) {
				System.out.println("main:" + i + " of " + k);
			}
			sharedLock = true;
			this.notify();
		}
	}
}
