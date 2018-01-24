package lib.datastructures.trees;

public class Node {
	private int key;
	private Node parent;
	private Node left;
	private Node right;

	Node(int key) {
		this.key = key;
		left = null;
		right = null;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getKey() {
		return key;
	}

	public Node getParent() {
		return parent;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
}
