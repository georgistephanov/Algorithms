package algorithms;

import lib.algorithms.Sort;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {
	private Integer [] unsortedInt = {2, 8, 7, 1, 9, 11, 3, 10, 5, 12, 6, 4};
	private Integer [] sortedInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private Character [] unsortedChar = "SORTEDEXAMPLE".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	private Character [] sortedChar = "ADEEELMOPRSTX".chars().mapToObj(c -> (char)c).toArray(Character[]::new);

	@Test
	public void selectionSort() throws Exception {
		Sort.selectionSort(unsortedInt);
		assertArrayEquals(unsortedInt, sortedInt);

		Sort.selectionSort(unsortedChar);
		assertArrayEquals(unsortedChar, sortedChar);
	}

	@Test
	public void insertionSort() throws Exception {
		Sort.insertionSort(unsortedInt);
		assertArrayEquals(unsortedInt, sortedInt);

		Sort.insertionSort(unsortedChar);
		assertArrayEquals(unsortedChar, sortedChar);
	}

	@Test
	public void bubbleSort() throws Exception {
		Sort.bubbleSort(unsortedInt);
		assertArrayEquals(unsortedInt, sortedInt);

		Sort.bubbleSort(unsortedChar);
		assertArrayEquals(unsortedChar, sortedChar);
	}

	@Test
	public void quickSort() throws Exception {
		Sort.quickSort(unsortedInt, 0, unsortedInt.length - 1);
		assertArrayEquals(unsortedInt, sortedInt);

		Sort.quickSort(unsortedChar, 0, unsortedChar.length - 1);
		assertArrayEquals(unsortedChar, sortedChar);
	}

}