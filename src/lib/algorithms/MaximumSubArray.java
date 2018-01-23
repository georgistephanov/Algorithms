package lib.algorithms;

public abstract class MaximumSubArray {

	/* @Returns
		Array with 3 elements in the form of the following tuple:
		 (left-index, right-index, sum-of-max-sub-array)
	*/
	public static int[] exec(int[] arr, int low, int high) {

		// Base Case - Array with only 1 element
		if (low == high) {
			int subArr[] = {low, high, arr[low]};
			return subArr;
		}
		else {
			int mid = (low + high) / 2;
			int[] left, right, cross;
			left = right = cross = new int[3];

			left = MaximumSubArray.exec(arr, low, mid);
			right = MaximumSubArray.exec(arr, mid+1, high);
			cross = MaximumSubArray.findMaxCrossingSubArray(arr, low, mid, high);

			// comparing the sums of the left, right and cross array
			if (left[2] >= right[2] && left[2] >= cross[2])
				return left;
			else if (right[2] >= left[2] && right[2] >= cross[2])
				return right;
			else
				return cross;
		}
	}

	public static int[] BruteForceAlgorithm(int[] arr, int low, int high) {
		int maxSubArr[] = new int[3];

		int maxSum = Integer.MIN_VALUE;
		int l_index = -1, r_index = -1;

		for (int i = low; i < high - 1; i++) {
			int sum = 0;

			for (int j = i; j < high; j++) {
				sum += arr[j];
				if (sum > maxSum) {
					maxSum = sum;
					l_index = i;
					r_index = j;
				}
			}
		}

		maxSubArr[0] = l_index;
		maxSubArr[1] = r_index;
		maxSubArr[2] = maxSum;

		return maxSubArr;
	}

	private static int[] findMaxCrossingSubArray(int[] arr, int low, int mid, int high ) {
		int a[] = new int[3];

		int max_left = Integer.MIN_VALUE, left_sum = 0, final_left_index = -1;
		for (int i = mid; i >= 0; i--) {
			left_sum += arr[i];

			if (left_sum > max_left) {
				max_left = left_sum;
				final_left_index = i;
			}
		}

		int max_right = Integer.MIN_VALUE, right_sum = 0, final_right_index = -1;
		for (int j = mid + 1; j <= high; j++) {
			right_sum += arr[j];

			if (right_sum > max_right) {
				max_right = right_sum;
				final_right_index = j;
			}
		}

		if (final_left_index != -1 && final_right_index != -1) {
			a[0] = final_left_index;
			a[1] = final_right_index;
			a[2] = max_left + max_right; // The sum of the maximum sub-array
		}

		return a;
	}
}
