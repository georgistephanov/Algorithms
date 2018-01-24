package lib.datastructures.trees;

public interface Tree {
	Node min();
	Node max();
	void insert(Node node);
	void delete(Node node);
	void inOrderTreeWalk();
}
