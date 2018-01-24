package lib.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<? super T>> implements Tree<T> {
	private Node root;

	public BinaryTree() {}

	/* ========== API Methods ========== */
	/**
	 * Finds and returns the minimum element in the binary tree
	 * @return the node of the minimum element
	 */
	public Node min() {
		return minimumElementInSubtree(root);
	}

	/**
	 * Finds and returns the maximum element in the binary tree
	 * @return the node of the maximum element
	 */
	public Node max() {
		return maximumElementInSubtree(root);
	}

	/**
	 * Traverse the tree via an in-order tree walk and print its elements to the console
	 */
	public List<T> inOrderTreeWalk() {
		ArrayList<T> array = new ArrayList<>();
		inOrderTreeWalk(array, root);

		return array;
	}

	/**
	 * Insert a node into the subtree
	 * @param node to be inserted
	 */
	@SuppressWarnings("unchecked")
	public void insert(Node<T> node) {
		Node<T> insertionPoint = null;
		Node<T> n = root;

		// Find the place where the new node should be inserted
		while (n != null) {
			insertionPoint = n;


			if ( node.getKey().compareTo(n.getKey()) <= 0 ) {
				n = n.getLeft();
			} else {
				n = n.getRight();
			}
		}

		// Set insertionPoint as the new node's parent
		node.setParent(insertionPoint);

		// Cover the three possible cases
		if (insertionPoint == null) {
			// The tree was empty
			root = node;

		} else if ( node.getKey().compareTo(insertionPoint.getKey()) <= 0 ) {
			// The new node is lesser or equal than insertionPoint
			insertionPoint.setLeft(node);
		} else {
			// The new node is greater than insertionPoint
			insertionPoint.setRight(node);
		}
	}

	/**
	 * Create a new node with a given value and insert it into the tree
	 * @param key of the node
	 */
	public void insert(T key) {
		insert(new Node<>(key));
	}

	/**
	 * Delete a node from the binary tree
	 * @param node to be deleted
	 */
	@SuppressWarnings("unchecked")
	public void delete(Node node) {
		if (node == null)
			return;

		if (node.getLeft() == null) {
			// Case 1:
			// The node doesn't have a left child, therefore replace it by its right child
			transplant(node, node.getRight());
		} else if (node.getRight() == null) {
			// Case 2:
			// The node doesn't have a right child, therefore replace it by its left child
			transplant(node, node.getLeft());
		} else {
			// Case 3:
			// The node has two children. Find its minimum child in the right subtree of the node and put this minimum
			// child at the node's position
			Node min = minimumElementInSubtree(node.getRight());

			// If the minimum node lies within the node's right subtree, replace min with its own right child
			if (min.getParent() != node) {
				transplant(min, min.getRight());
				min.setRight(node.getRight());
				min.getRight().setParent(min);
			}

			// Replace the node with the minimum element in its right subtree.
			transplant(node, min);
			min.setLeft(node.getLeft());
			min.getLeft().setParent(min);
		}
	}

	/* ========== Private methods ========== */
	/**
	 * Find the minimum element in a subtree of the binary tree.
	 * @param n the root node of the subtree
	 * @return the minimum element
	 */
	private Node minimumElementInSubtree(final Node n) {
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
	 * Find the maximum element in a subtree of the binary tree.
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
	private void transplant(Node initialSubtree, Node<T> substituteSubtree) {
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

	/**
	 * Traverses the tree and prints its elements to the console
	 * @param node the current node that is being accessed
	 */
	@SuppressWarnings("unchecked")
	private void inOrderTreeWalk(List<T> array, Node<T> node) {
		if ( node != null ) {
			inOrderTreeWalk(array, node.getLeft());
			array.add(node.getKey());
			inOrderTreeWalk(array, node.getRight());
		}
	}
}
