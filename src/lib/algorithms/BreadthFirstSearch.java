package lib.algorithms;

import lib.datastructures.basic.linkedlist.LinkedList;
import lib.datastructures.graphs.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public final class BreadthFirstSearch {
	private final Graph graph;

	private Queue<Integer> queue;
	private boolean [] visited;
	private int [] cameFrom;
	private int [] distance;

	public BreadthFirstSearch(Graph graph, int startVertex) {
		this.graph = graph;

		int numVertices = graph.V();
		queue = new ArrayDeque<>(numVertices);
		visited = new boolean[numVertices];
		cameFrom = new int[numVertices];
		distance = new int[numVertices];

		for (int i : cameFrom) i = -1;

		cameFrom[startVertex] = startVertex;
		bfs(startVertex);
	}

	private void bfs(int vertex) {
		queue.add(vertex);
		visited[vertex] = true;
		cameFrom[vertex] = vertex;
		distance[vertex] = 0;

		while ( !queue.isEmpty() ) {
			int currVertex = queue.remove();

			System.out.print((currVertex + 1) + " -> ");

			LinkedList<Integer> adj = graph.adj(currVertex);
			for (int i = 0; i < adj.size(); i++) {
				int index = adj.at(i).getKey();

				if (visited[index]) {
					continue;
				}

				queue.add(index);
				visited[index] = true;
				cameFrom[index] = currVertex;
				distance[index] = distance[currVertex] + 1;
			}
		}
	}
}
