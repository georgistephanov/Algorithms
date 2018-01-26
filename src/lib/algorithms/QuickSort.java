package lib.algorithms;

public abstract class QuickSort {

	public static <T extends Comparable<? super T>> void sort(T A[], int start, int end) {
		if (start < end) {
			int q = Partition(A, start, end);
			sort(A, start, q - 1);
			sort(A, q + 1, end);
		}
	}

	private static <T extends Comparable<? super T>> int Partition(T A[], int start, int end) {
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (A[j].compareTo(A[end]) < 0) {
				i++;
				T temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}

		i++;
		T temp = A[i];
		A[i] = A[end];
		A[end] = temp;

		return i;
	}
}
