package Strategy;

public class DefaultStrategy implements Strategy {

	@Override
	public boolean equal(Object obj1, Object obj2) {
		return obj1.toString().equals(obj2.toString());
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		int a = obj1.toString().compareTo(obj2.toString());
		if (a > 0) {
			return 1;
		} else if (a == 0) {
			return 0;
		} else return -1;
	}
}
