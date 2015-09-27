package thread;

public class ThreadCommunication {
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
		synchronized void sub(int i) {
			while (!sub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 10; j++) {
				System.out.println("sub inner:"+j+" outer:"+i);
			}
			sub = false;
			this.notify();
		}
		synchronized void main(int i) {
			while (sub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 5; j++) {
				System.out.println("main inner:"+j+" outer:"+i);
			}
			sub = true;
			this.notify();
		}
	}
}
