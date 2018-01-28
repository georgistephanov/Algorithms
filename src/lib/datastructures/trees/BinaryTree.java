package lib.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public final class BinaryTree<T extends Comparable<? super T>> extends AbstractTree<T> {
	public BinaryTree() {}

	/* ========== API Methods ========== */
	/**
	 * Create a new node with a given value and insert it into the tree
	 * @param key of the node
	 */
	public void insert(T key) {
		insert(new TreeNode<>(key));
	}

	/**
	 * Delete a node from the binary tree
	 * @param node to be deleted
	 */
	@SuppressWarnings("unchecked")
	public void delete(TreeNode node) {
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
			TreeNode min = minimumElementInSubtree(node.getRight());

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

	/**
	 * Traverse the tree via an in-order tree walk and print its elements to the console
	 */
	@SuppressWarnings("unchecked")
	public List<T> inOrderTreeWalk() {
		ArrayList<T> array = new ArrayList<>();
		inOrderTreeWalk(array, root);

		return array;
	}

	/* ========== Private methods ========== */
	/**
	 * Insert a node into the subtree
	 * @param node to be inserted
	 */
	@SuppressWarnings("unchecked")
	private void insert(TreeNode<T> node) {
		TreeNode<T> insertionPoint = null;
		TreeNode<T> n = root;

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
	 * Traverses the tree and prints its elements to the console
	 * @param node the current node that is being accessed
	 */
	@SuppressWarnings("unchecked")
	private void inOrderTreeWalk(List<T> array, TreeNode<T> node) {
		if ( node != null ) {
			inOrderTreeWalk(array, node.getLeft());
			array.add(node.getKey());
			inOrderTreeWalk(array, node.getRight());
		}
	}
}
