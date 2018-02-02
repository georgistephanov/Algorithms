package lib.algorithms;

public final class Sort {
	private static Comparable [] aux;	// Static auxiliary array for the merge sort

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

	public static <T extends Comparable<? super T>> void shellSort(T [] array) {
		int interval = 1;

		while (interval < array.length / 3) {
			interval = interval * 3 + 1;
		}

		while (interval > 0) {
			for (int i = interval; i < array.length; i++) {
				for (int j = i; j >= interval && array[j].compareTo(array[j - interval]) < 0; j -= interval) {
					swap(array, j, j - interval);
				}
			}

			interval /= 3;
		}
	}

	public static <T extends Comparable<? super T>> void mergeSort(T [] array) {
		aux = new Comparable[array.length];
		topDownMergeSort(array, 0, array.length - 1);
	}

	public static <T extends Comparable<? super T>> void bottomUpMergeSort(T [] array) {
		aux = new Comparable[array.length];

		for (int len = 1; len < array.length; len *= 2) {
			for (int low = 0; low < array.length - len; low += len*2) {
				merge(array, low, low + len - 1, Math.min(low+len+len-1, array.length-1));
			}
		}
	}

	private static <T extends Comparable<? super T>> void topDownMergeSort(T [] array, int low, int high) {
		if (high <= low)
			return;

		int mid = low + (high - low) / 2;
		topDownMergeSort(array, low, mid);
		topDownMergeSort(array, mid + 1, high);
		merge(array, low, mid, high);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<? super T>> void merge(T [] array, int low, int mid, int high) {
		int lo = low;
		int hi = mid + 1;

		for (int i = low; i <= high; i++) {
			aux[i] = array[i];
		}

		for (int i = low; i <= high; i++) {
			if 		(lo > mid)								array[i] = (T) aux[hi++];	// First half is already sorted
			else if (hi > high)								array[i] = (T) aux[lo++]; 	// Second half is already sorted
			else if (aux[hi].compareTo(aux[lo]) < 0)		array[i] = (T) aux[hi++]; 	// Element from second half is smaller -> it goes next
			else											array[i] = (T) aux[lo++];   // Element from first half is smaller -> it goes next
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
