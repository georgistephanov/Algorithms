package lib.datastructures.basic.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {
	private MinHeap heap = new MinHeap();

	@Test
	public void insert() throws Exception {
		heap.insert(13);
		assertEquals(heap.peek(), 13);

		heap.insert(8);
		assertEquals(heap.peek(), 8);

		heap.insert(14);
		assertEquals(heap.peek(), 8);

		heap.insert(16);
		assertEquals(heap.peek(), 8);

		heap.insert(5);
		assertEquals(heap.peek(), 5);

		heap.insert(2);
		assertEquals(heap.peek(), 2);
	}

	@Test
	public void removeMin() throws Exception {
		heap.insert(13);
		heap.insert(14);
		heap.insert(16);
		heap.insert(8);

		assertEquals(heap.remove(), 8);
		assertEquals(heap.remove(), 13);
		assertEquals(heap.remove(), 14);
		assertEquals(heap.remove(), 16);
	}

}