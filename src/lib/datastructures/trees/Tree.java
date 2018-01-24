package lib.datastructures.trees;

import java.util.List;

public interface Tree<T> {
	Node min();
	Node max();
	void insert(Node<T> node);
	void delete(Node node);
	List<T> inOrderTreeWalk();
}
