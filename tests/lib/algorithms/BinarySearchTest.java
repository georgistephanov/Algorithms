package lib.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
	private Integer [] unsortedArray = {12, 15, 4, 3, 19, 24, 17, 8};
	private Integer [] sortedArray = {3, 4, 8, 12, 15, 17, 19, 24};

	@Test
	public void search() throws Exception {
		// Iterative binary search on unsorted array
		assertEquals(BinarySearch.search(unsortedArray, -1, false), Integer.MIN_VALUE);
		assertEquals(BinarySearch.search(unsortedArray, 3, false), 0);
		assertEquals(BinarySearch.search(unsortedArray, 12, false), 3);
		assertEquals(BinarySearch.search(unsortedArray, 24, false), 7);

		// Iterative binary search on sorted array
		assertEquals(BinarySearch.search(sortedArray, -1, false), Integer.MIN_VALUE);
		assertEquals(BinarySearch.search(sortedArray, 3, false), 0);
		assertEquals(BinarySearch.search(sortedArray, 12, false), 3);
		assertEquals(BinarySearch.search(sortedArray, 24, false), 7);
	}

	@Test
	public void searchRecursively() throws Exception {
		// Recursive binary search on unsorted array
		assertEquals(BinarySearch.searchRecursively(unsortedArray, -1, 0, unsortedArray.length - 1, false), Integer.MIN_VALUE);
		assertEquals(BinarySearch.searchRecursively(unsortedArray, 3, 0, unsortedArray.length - 1, false), 0);
		assertEquals(BinarySearch.searchRecursively(unsortedArray, 12, 0, unsortedArray.length - 1, false), 3);
		assertEquals(BinarySearch.searchRecursively(unsortedArray, 24, 0, unsortedArray.length - 1, false), 7);

		// Recursive binary search on sorted array
		assertEquals(BinarySearch.searchRecursively(sortedArray, -1, 0, sortedArray.length - 1, false), Integer.MIN_VALUE);
		assertEquals(BinarySearch.searchRecursively(sortedArray, 3, 0, sortedArray.length - 1, false), 0);
		assertEquals(BinarySearch.searchRecursively(sortedArray, 12, 0, sortedArray.length - 1, false), 3);
		assertEquals(BinarySearch.searchRecursively(sortedArray, 24, 0, sortedArray.length - 1, false), 7);
	}

}