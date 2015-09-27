package thread;
import java.util.Random;

/**
 * test ThreadLocal
 * @author Administrator
 *
 */
public class ThreadLocalTest {
	
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					String name = Thread.currentThread().getName() + data;
					ShareDate sd = ShareDate.getInstance();
					sd.setName(name);
					sd.setAge(data);
					
					System.out.println(Thread.currentThread().getName()
						+" start!");
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A {
		void get() {
			ShareDate sd = ShareDate.getInstance();
			System.out.println("A from " + Thread.currentThread().getName()
					+" ---- "	+ sd);
		}
	}

	static class B {
		void get() {
			ShareDate sd = ShareDate.getInstance();
			System.out.println("B from " + Thread.currentThread().getName()
					+" ---- "+ sd);
		}
	}
}

class ShareDate {
	private static ThreadLocal<ShareDate> map = new ThreadLocal<>();
	private ShareDate() {};
	public static ShareDate getInstance() {
		ShareDate sd = map.get();
		if (sd == null) {
			sd = new ShareDate();
			map.set(sd);
		}
		return sd;
	}
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ShareDate [name=" + name + ", age=" + age + "]";
	}
}