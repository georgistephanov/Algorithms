package lib.datastructures.trees;

public class Node<T> {
	private T key;
	private Node parent;
	private Node left;
	private Node right;

	Node(T key) {
		this.key = key;
		left = null;
		right = null;
	}

	public T getKey() {
		return key;
	}

	void setKey(T key) {
		this.key = key;
	}

	Node getParent() {
		return parent;
	}

	void setParent(Node parent) {
		this.parent = parent;
	}

	Node getLeft() {
		return left;
	}

	void setLeft(Node left) {
		this.left = left;
	}

	Node getRight() {
		return right;
	}

	void setRight(Node right) {
		this.right = right;
	}
}
