package lib.datastructures.trees;

public final class TreeNode<T> {
	private final T key;
	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	private NodeColor color;

	public enum NodeColor {
		RED, BLACK
	}

	TreeNode(T key) {
		this.key = key;
		left = null;
		right = null;
	}

	public T getKey() {
		return key;
	}

	TreeNode getParent() {
		return parent;
	}

	void setParent(TreeNode parent) {
		this.parent = parent;
	}

	TreeNode getLeft() {
		return left;
	}

	void setLeft(TreeNode left) {
		this.left = left;
	}

	TreeNode getRight() {
		return right;
	}

	void setRight(TreeNode right) {
		this.right = right;
	}

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}
}
