package lib.algorithms;

import lib.datastructures.basic.linkedlist.LinkedList;
import lib.datastructures.graphs.Graph;

public final class DepthFirstSearch {

	private final Graph graph;
	private boolean [] visited;

	public DepthFirstSearch(Graph graph, int startVertex) {
		this.graph = graph;

		visited = new boolean[graph.V()];

		dfs(startVertex);
	}

	private void dfs(int startVertex) {
		System.out.print((startVertex + 1) + " -> ");
		visited[startVertex] = true;

		LinkedList<Integer> adj = graph.adj(startVertex);
		for (int i = 0; i < adj.size(); i++) {
			int index = adj.at(i).getKey();

			if (visited[index]) continue;

			dfs(index);
		}
	}
}
