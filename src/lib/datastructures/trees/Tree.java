package lib.datastructures.trees;

public interface Tree<T> {
	Node min();
	Node max();
	void insert(Node<T> node);
	void delete(Node node);
	void inOrderTreeWalk();
}
