package mypack;

public class Counter {
	private int count;
	
	Counter(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void add(int x) {
		count += x;
	}
}
