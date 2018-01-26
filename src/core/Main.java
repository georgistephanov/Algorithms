/*
	This is a project where I write the algorithms I learn in practice.
	This project has been started on 29.09.2017.
	Let's see how big it can grow ;-)
 */

package core;
import lib.algorithms.*;
import lib.datastructures.trees.BinaryTree;

public class Main {

	public static void main(String[] args) {
		// Find max sub-array
		{
			int arr[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
			int maxSubArr[];

			// Correct output should be (7, 10, 43)
			maxSubArr = MaximumSubArray.exec(arr, 0, arr.length - 1);

			System.out.println("Maximum sub-array problem:\nLeft index: " + maxSubArr[0]
					+ "\nRight index: " + maxSubArr[1] + "\nSum: " + maxSubArr[2] + "\n\n");
		}

		// QuickSort
		{
			Integer [] arr2 = {2, 8, 7, 1, 9, 11, 3, 10, 5, 12, 6, 4};

			System.out.println("Array 2 before sorting it with quicksort");
			printArr(arr2);

			QuickSort.sort(arr2, 0, arr2.length - 1);

			System.out.println("\nArray 2 after sorting it with quicksort");
			printArr(arr2);
		}

		// Binary search
		{
			BinaryTree<Integer> bt = new BinaryTree<>();
			bt.insert(12);
			bt.insert(5);
			bt.insert(18);
			bt.insert(2);
			bt.insert(9);
			bt.insert(15);
			bt.insert(13);
			bt.insert(19);
			bt.insert(17);

			System.out.println();
			bt.inOrderTreeWalk();
		}
	}

	private static void printArr(Integer a[]) {
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}
}
