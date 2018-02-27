package lib.datastructures.graphs;

import lib.datastructures.basic.LinkedList;
import lib.datastructures.basic.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedGraphTest {
	private Graph graph = new DirectedGraph(5);

	@Test
	public void v() throws Exception {
		assertEquals(graph.V(), 5);
	}

	@Test
	public void e() throws Exception {
		assertEquals(graph.E(), 0);

		graph.addEdge(0, 1);
		assertEquals(graph.E(), 1);

		graph.addEdge(1, 0);
		assertEquals(graph.E(), 2);
	}

	@Test
	public void addEdge() throws Exception {
		assertEquals(graph.E(), 0);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		assertEquals(graph.E(), 3);

		graph.addEdge(1, 0);
		graph.addEdge(3, 0);
		assertEquals(graph.E(), 5);
	}

	@Test
	public void adj() throws Exception {
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 3);

		LinkedList<Integer> zero = new SinglyLinkedList<>();
		zero.insertFirst(1);
		zero.insertFirst(2);
		zero.insertFirst(3);

		assertEquals(graph.adj(0).at(0).getKey(), zero.at(0).getKey());
		assertEquals(graph.adj(0).at(1).getKey(), zero.at(1).getKey());
		assertEquals(graph.adj(0).at(2).getKey(), zero.at(2).getKey());

		LinkedList<Integer> three = new SinglyLinkedList<>();
		three.insertFirst(4);
		assertEquals(graph.adj(3).at(0).getKey(), three.at(0).getKey());

		LinkedList<Integer> four = new SinglyLinkedList<>();
		four.insertFirst(3);
		assertEquals(graph.adj(4).at(0).getKey(), four.at(0).getKey());
	}
}