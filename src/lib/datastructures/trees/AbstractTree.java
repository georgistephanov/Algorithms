package lib.datastructures.trees;

import java.util.List;

public abstract class AbstractTree<T> implements Tree<T> {
	Node root;

	/**
	 * Finds and returns the minimum element in the tree
	 * @return the node of the minimum element
	 */
	@Override
	public Node min() {
		return minimumElementInSubtree(root);
	}

	/**
	 * Finds and returns the maximum element in the tree
	 * @return the node of the maximum element
	 */
	@Override
	public Node max() { return maximumElementInSubtree(root); }

	@Override
	public abstract void insert(T key);

	@Override
	public abstract void delete(Node node);

	@Override
	public abstract List<T> inOrderTreeWalk();

	/**
	 * Find the minimum element in a subtree
	 * @param n the root node of the subtree
	 * @return the minimum element
	 */
	Node minimumElementInSubtree(final Node n) {
		if (n == null) {
			return null;
		}

		Node node = n;

		while (node.getLeft() != null) {
			node = node.getLeft();
		}

		return node;
	}

	/**
	 * Find the maximum element in a subtree
	 * @param n the root of the subtree
	 * @return the maximum element
	 */
	private Node maximumElementInSubtree(final Node n) {
		if (n == null) {
			return null;
		}

		Node node = n;

		while (node.getRight() != null) {
			node = node.getRight();
		}

		return node;
	}

	/**
	 * Replaces one subtree as a child of its parent with another subtree.
	 * @param initialSubtree root node of the initial subtree
	 * @param substituteSubtree root node of the substitute subtree
	 */
	void transplant(Node initialSubtree, Node<T> substituteSubtree) {
		if (initialSubtree.getParent() == null) {
			root = substituteSubtree;
		} else if (initialSubtree == initialSubtree.getParent().getLeft()) {
			// If the initialSubtree is a leftSubtree
			initialSubtree.getParent().setLeft(substituteSubtree);
		} else {
			// The initialSubtree is a right subtree
			initialSubtree.getParent().setRight(substituteSubtree);
		}

		if ( substituteSubtree != null ) {
			substituteSubtree.setParent(initialSubtree.getParent());
		}
	}
}
