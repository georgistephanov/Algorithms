package datastructures.basic;

import lib.datastructures.basic.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
	private LinkedList<Integer> list = new LinkedList<>();

	@Test
	public void getFirst() throws Exception {
		assertTrue(list.getFirst().getKey() == null);

		list.addFirst(10);
		assertTrue(list.getFirst().getKey() == 10);

		list.addFirst(15);
		assertTrue(list.getFirst().getKey() == 15);
	}

	@Test
	public void getLast() throws Exception {
		assertTrue(list.getLast().getKey() == null);

		list.addLast(10);
		assertTrue(list.getLast().getKey() == 10);

		list.addLast(15);
		assertTrue(list.getLast().getKey() == 15);
	}

	@Test
	public void at() throws Exception {
		assertTrue(list.at(1).getKey() == null);

		list.addFirst(5);
		list.addLast(10);
		list.addLast(15);

		assertTrue(list.at(0).getKey() == 5);
		assertTrue(list.at(1).getKey() == 10);
		assertTrue(list.at(2).getKey() == 15);
		assertTrue(list.at(3).getKey() == null);


	}

	@Test
	public void deleteFirst() throws Exception {
		list.addFirst(5);
		list.addLast(10);
		list.addLast(15);

		list.deleteFirst();
		assertTrue(list.getFirst().getKey() == 10);

		list.deleteFirst();
		assertTrue(list.getFirst().getKey() == 15);

		list.deleteFirst();
		list.deleteFirst();
		assertTrue(list.getFirst().getKey() == null);
	}

	@Test
	public void deleteLast() throws Exception {
		list.addFirst(5);
		list.addLast(10);
		list.addLast(15);

		list.deleteLast();
		assertTrue(list.getLast().getKey() == 10);

		list.deleteLast();
		assertTrue(list.getLast().getKey() == 5);

		list.deleteLast();
		list.deleteLast();
		assertTrue(list.getLast().getKey() == null);
	}

	@Test
	public void size() throws Exception {
		assertTrue(list.size() == 0);

		list.addFirst(5);
		assertTrue(list.size() == 1);

		list.addLast(10);
		assertTrue(list.size() == 2);

		list.deleteFirst();
		assertTrue(list.size() == 1);

		list.deleteLast();
		assertTrue(list.size() == 0);
	}

}