package lib.datastructures.basic.linkedlist;

import lib.datastructures.basic.linkedlist.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
	private SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

	@Test
	public void getFirst() throws Exception {
		assertTrue(list.getFirst().getKey() == null);

		list.insertFirst(10);
		assertTrue(list.getFirst().getKey() == 10);

		list.insertFirst(15);
		assertTrue(list.getFirst().getKey() == 15);
	}

	@Test
	public void getLast() throws Exception {
		assertTrue(list.getLast().getKey() == null);

		list.insertLast(10);
		assertTrue(list.getLast().getKey() == 10);

		list.insertLast(15);
		assertTrue(list.getLast().getKey() == 15);
	}

	@Test
	public void at() throws Exception {
		assertTrue(list.at(1).getKey() == null);

		list.insertFirst(5);
		list.insertLast(10);
		list.insertLast(15);

		assertTrue(list.at(0).getKey() == 5);
		assertTrue(list.at(1).getKey() == 10);
		assertTrue(list.at(2).getKey() == 15);
		assertTrue(list.at(3).getKey() == null);
	}

	@Test
	public void deleteFirst() throws Exception {
		list.insertFirst(5);
		list.insertLast(10);
		list.insertLast(15);

		list.removeFirst();
		assertTrue(list.getFirst().getKey() == 10);

		list.removeFirst();
		assertTrue(list.getFirst().getKey() == 15);

		list.removeFirst();
		list.removeFirst();
		assertTrue(list.getFirst().getKey() == null);
	}

	@Test
	public void deleteLast() throws Exception {
		list.insertFirst(5);
		list.insertLast(10);
		list.insertLast(15);

		list.removeLast();
		assertTrue(list.getLast().getKey() == 10);

		list.removeLast();
		assertTrue(list.getLast().getKey() == 5);

		list.removeLast();
		list.removeLast();
		assertTrue(list.getLast().getKey() == null);
	}

	@Test
	public void size() throws Exception {
		assertTrue(list.size() == 0);

		list.insertFirst(5);
		assertTrue(list.size() == 1);

		list.insertLast(10);
		assertTrue(list.size() == 2);

		list.removeFirst();
		assertTrue(list.size() == 1);

		list.removeLast();
		assertTrue(list.size() == 0);
	}

}