package lib.datastructures.basic.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {
	private MaxHeap heap = new MaxHeap();

	@Test
	public void insert() throws Exception {
		heap.insert(13);
		assertEquals(heap.peek(), 13);

		heap.insert(8);
		assertEquals(heap.peek(), 13);

		heap.insert(14);
		assertEquals(heap.peek(), 14);

		heap.insert(16);
		assertEquals(heap.peek(), 16);

		heap.insert(5);
		assertEquals(heap.peek(), 16);

		heap.insert(2);
		assertEquals(heap.peek(), 16);
	}

	@Test
	public void remove() throws Exception {
		heap.insert(13);
		heap.insert(14);
		heap.insert(16);
		heap.insert(8);

		assertEquals(heap.remove(), 16);
		assertEquals(heap.remove(), 14);
		assertEquals(heap.remove(), 13);
		assertEquals(heap.remove(), 8);
	}

}