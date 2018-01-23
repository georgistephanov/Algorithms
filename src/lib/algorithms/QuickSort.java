package lib.algorithms;

public abstract class QuickSort {
	public static void sort(int A[], int start, int end) {
		if (start < end) {
			int q = Partition(A, start, end);
			sort(A, start, q - 1);
			sort(A, q + 1, end);
		}
	}

	private static int Partition(int A[], int start, int end) {
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (A[j] < A[end]) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}

		i++;
		int temp = A[i];
		A[i] = A[end];
		A[end] = temp;

		return i;
	}
}
