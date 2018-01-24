package lib.datastructures.trees;

class Node<T> {
	private T key;
	private Node parent;
	private Node left;
	private Node right;

	Node(T key) {
		this.key = key;
		left = null;
		right = null;
	}

	void setKey(T key) {
		this.key = key;
	}

	void setParent(Node parent) {
		this.parent = parent;
	}

	void setLeft(Node left) {
		this.left = left;
	}

	void setRight(Node right) {
		this.right = right;
	}

	T getKey() {
		return key;
	}

	Node getParent() {
		return parent;
	}

	Node getLeft() {
		return left;
	}

	Node getRight() {
		return right;
	}
}
