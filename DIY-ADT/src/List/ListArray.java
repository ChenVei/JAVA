package List;

import java.util.Arrays;

import Exception.OutOfBoundaryException;
import Strategy.DefaultStrategy;
import Strategy.Strategy;

public class ListArray implements List {

	private Object[] elements;
	private final int LEN = 5;
	private Strategy strategy;
	private int size;

	public ListArray() {
		this(new DefaultStrategy());
	}

	public ListArray(Strategy strategy) {
		super();
		this.strategy = strategy;
		elements = new Object[LEN];
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object e) {
		for (Object o : elements) {
			if (strategy.equal(o, e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object e) {
		int index = 0;
		for (Object o : elements) {
			if (strategy.equal(o, e)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public void insert(int i, Object e) throws OutOfBoundaryException {
		if (i < 0 || i > size) {
			throw new OutOfBoundaryException("IndexOutOfBoundary");
		}
		if (size >= elements.length) {
			expand();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j-1];
		}
		elements[i] = e;
		size++;
	}

	private void expand() {
		Object[] a = new Object[elements.length * 2];
		for (int i = 0; i < size; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	@Override
	public boolean insertBefore(Object obj, Object e) {
		int i = indexOf(obj);
		if (i == -1)
			return false;
		insert(i, e);
		return true;
	}

	@Override
	public boolean insertAfter(Object obj, Object e) {
		int i = indexOf(obj);
		if (i == -1)
			return false;
		insert(i + 1, e);
		return true;
	}

	@Override
	public Object remove(int i) throws OutOfBoundaryException {
		if (i < 0 || i >= size) {
			throw new OutOfBoundaryException("IndexOutOfBoundary");
		}
		Object obj = elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j+1];
		}
		elements[--size] = null;   //cool
		return obj;
	}

	@Override
	public boolean remove(Object e) {
		int i = indexOf(e);
		if (i == -1)
			return false;
		remove(i);
		return true;
	}

	@Override
	public Object replace(int i, Object e) throws OutOfBoundaryException {
		if (i < 0 || i >= size) {
			throw new OutOfBoundaryException("IndexOutOfBoundary");
		}
		Object obj = elements[i];
		elements[i] = e;
		return obj;
	}

	@Override
	public Object get(int i) throws OutOfBoundaryException {
		if (i < 0 || i >= size) {
			throw new OutOfBoundaryException("IndexOutOfBoundary");
		}
		return elements[i];
	}

	@Override
	public String toString() {
		return "ListArray [elements=" + Arrays.toString(elements) + ", size=" + size + "]";
	}

}
