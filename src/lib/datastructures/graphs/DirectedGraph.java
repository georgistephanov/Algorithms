package lib.datastructures.graphs;

import lib.datastructures.basic.LinkedList;
import lib.datastructures.basic.SinglyLinkedList;

import java.security.InvalidParameterException;

public final class DirectedGraph implements Graph {

	private final int vertices;
	private LinkedList<Integer> [] adjacent;

	@SuppressWarnings("unchecked")
	DirectedGraph(int vertices) {
		this.vertices = vertices;

		adjacent = (LinkedList<Integer> []) new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacent[i] = new SinglyLinkedList<>();
		}
	}

	@Override
	public int V() {
		return vertices;
	}

	@Override
	public int E() {
		int edges = 0;

		for (LinkedList<Integer> adj : adjacent) {
			edges += adj.size();
		}

		return edges;
	}

	@Override
	public void addEdge(int v, int w) {
		if ((v < 0 || v >= vertices) || (w < 0 || w >= vertices))
			throw new InvalidParameterException("Both vertices must be between 0 and G.V()");

		adjacent[v].insertFirst(w);
	}

	@Override
	public LinkedList<Integer> adj(int v) {
		if (v < 0 || v >= vertices)
			throw new InvalidParameterException("The vertex must be between 0 and G.V()");

		return adjacent[v];
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; i < adjacent[i].size(); i++) {
				stringBuilder.append(i);
				stringBuilder.append(" -> ");
				stringBuilder.append(adjacent[i].at(j));
				stringBuilder.append("\n");
			}
		}

		return stringBuilder.toString();
	}
}
