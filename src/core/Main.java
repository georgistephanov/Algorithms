/*
	This is a project where I write the algorithms I learn in practice.
	This project has been started on 29.09.2017.
	Let's see how big it can grow ;-)
 */

package core;
import lib.algorithms.*;
import lib.datastructures.graphs.Graph;
import lib.datastructures.graphs.UndirectedGraph;
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

		// BFS and DFS
		Graph graph = new UndirectedGraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);

		System.out.println("Depth first search: ");
		new DepthFirstSearch(graph, 0);

		System.out.println("\nBreadth first search: ");
		new BreadthFirstSearch(graph, 0);
	}

	private static void printArr(Integer a[]) {
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}
}
