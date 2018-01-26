package lib.algorithms;

public class BinarySearch {

	/**
	 * Iterative implementation of binary search on a generic array.
	 * @param array array of generic elements
	 * @param find the element to look for
	 * @param isSorted whether or not the array is sorted
	 * @return the index of the element or Integer.MIN_VALUE if it isn't found
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> int search(T array[], T find, boolean isSorted) {
		if ( !isSorted ) {
			QuickSort.sort(array, 0, array.length - 1);
		}

		int start = 0;
		int end = array.length - 1;

		while ( start <= end ) {
			int mid = (start + end) / 2;

			if ( array[mid] == find ) {
				return mid;
			} else if ( find.compareTo(array[mid]) < 0 ) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return Integer.MIN_VALUE;
	}

	/**
	 * Recursive implementation of binary search on a generic array.
	 * @param array array of generic elements
	 * @param find the element to look for
	 * @param isSorted whether or not the array is sorted
	 * @return the index of the element or Integer.MIN_VALUE if it isn't found
	 */
	public static <T extends Comparable<? super T>> int searchRecursively(T array[], T find, int low, int high, boolean isSorted) {
		if ( high < low ) {
			return Integer.MIN_VALUE;
		}

		if ( !isSorted ) {
			QuickSort.sort(array, 0, array.length - 1);
		}

		int mid = (low + high) / 2;

		if ( array[mid] == find ) {
			return mid;
		} else if ( find.compareTo(array[mid]) < 0 ) {
			return searchRecursively(array, find, low, mid - 1, true);
		} else {
			return searchRecursively(array, find, mid + 1, high, true);
		}
	}

}
