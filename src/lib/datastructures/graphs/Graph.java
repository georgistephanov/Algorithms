package lib.datastructures.graphs;

import lib.datastructures.basic.LinkedList;

public interface Graph {
	int V();
	int E();
	void addEdge(int v, int w);
	LinkedList<Integer> adj(int v);
}
