package tEST;

public class A {

	public void ini() {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					t.output1("abcdefghijklmn");
				}
			}
		}.start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					t.output3("123456789");
				}
			}
		}).start();
	};

	public static void main(String args[]) {
		 new A().ini();
	}

	T t = new T();

	static class T {

		public void output1(String s) {
			synchronized (T.class) {
				for (int i = 0; i < s.length(); i++) {
					System.out.print(s.charAt(i));
				}
				System.out.println();
			}
		}
		
		public synchronized void output2(String s) {
				for (int i = 0; i < s.length(); i++) {
					System.out.print(s.charAt(i));
				}
				System.out.println();
		}
		
		public static synchronized void output3(String s) {
			for (int i = 0; i < s.length(); i++) {
				System.out.print(s.charAt(i));
			}
			System.out.println();
		}
	}

}
