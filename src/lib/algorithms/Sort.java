package lib.algorithms;

public final class Sort {
	private Sort() {}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void selectionSort(T [] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}

			if (array[i] != array[minIndex]) {
				swap(array, i, minIndex);
			}
		}
	}

	public static <T extends Comparable<? super T>> void insertionSort(T [] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
				swap(array, j, j-1);
			}
		}
	}

	public static <T extends Comparable<? super T>> void bubbleSort(T [] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[j].compareTo(array[j-1]) < 0) {
					swap(array, j, j-1);
				}
			}
		}
	}

	public static <T extends Comparable<? super T>> void quickSort(T [] array, int start, int end) {
		if (start < end) {
			int q = partition(array, start, end);
			quickSort(array, start, q - 1);
			quickSort(array, q + 1, end);
		}
	}

	private static <T extends Comparable<? super T>> int partition(T [] array, int start, int end) {
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (array[j].compareTo(array[end]) < 0) {
				i++;
				swap(array, i, j);
			}
		}

		i++;
		swap(array, i, end);

		return i;
	}

	private static <T extends Comparable<? super T>> void swap(T [] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
