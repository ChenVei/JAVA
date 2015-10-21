package List;

import java.util.Random;

import org.junit.Test;

public class ListArrayTest {
	
	ListArray arr = new ListArray();
	{
		for (int i = 0; i < 5; i++) {
			arr.insert(i, i+1);
		}
	}
	@Test
	public void testGetSize() {
		System.out.println(arr.getSize());
	}

	@Test
	public void testIsEmpty() {
		System.out.println(arr.isEmpty());
	}

	@Test
	public void testContains() {
		System.out.println(arr.contains(3));
		System.out.println(arr.contains(6));
	}

	@Test
	public void testIndexOf() {
		System.out.println(arr.indexOf(5));
		System.out.println(arr.indexOf(6));
	}
	
	@Test
	public void testInsert() {
		for (int i = 0; i < 10; i++) {
			arr.insert(5, new Random().nextInt(20));
		}
		System.out.println(arr);
	}

	@Test
	public void testInsertBefore() {
		for (int i = 0; i < 10; i++) {
			arr.insertBefore(1, new Random().nextInt(20));
		}
		System.out.println(arr);
	}

	@Test
	public void testInsertAfter() {
		for (int i = 0; i < 10; i++) {
			arr.insertAfter(1, new Random().nextInt(20));
		}
		System.out.println(arr);
	}

	@Test
	public void testRemove() {
		arr.remove(3);
		System.out.println(arr);
	}

	@Test
	public void testReplace() {
		arr.replace(4, 25);
		System.out.println(arr);
	}

	@Test
	public void testGet() {
		System.out.println(arr.get(4));
	}

}
