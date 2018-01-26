package lib.datastructures.trees;

import java.util.List;

public class RedBlackTree<T extends Comparable<? super T>> extends AbstractTree<T> {
	private final Node<T> nil = new Node<T>(null);

	public RedBlackTree() {
		root.setParent(nil);
	}

	@Override
	public void insert(T key) {

	}

	@Override
	public void delete(Node node) {

	}

	@Override
	public List<T> inOrderTreeWalk() {
		return null;
	}

	/**
	 * This method performs a left rotation around a node. The node around which is
	 * being rotated becomes its right child's left child. The left child of the right child
	 * of the node becomes the node's right child in order to preserve the tree's binary properties.
	 * @param node around which to rotate
	 */
	private void leftRotate(Node node) {
		if ( node == null || !(node.getRight().equals(nil)) )
			return;

		Node initialRightChild = node.getRight() != null ? node.getRight() : new Node<T>(null);
		node.setRight(initialRightChild.getLeft());

		if (initialRightChild.getLeft() != nil) {
			initialRightChild.getLeft().setParent(node);
		}

		if (node.getParent().equals(nil)) {
			root = initialRightChild;
		} else if (node.equals(node.getParent().getLeft())) {
			node.getParent().setLeft(initialRightChild);
		} else {
			node.getParent().setRight(initialRightChild);
		}

		initialRightChild.setLeft(node);
		node.setParent(initialRightChild);
	}

	/**
	 * This method performs a right rotation around a node. The node around which is
	 * being rotated becomes its parent's parent. The right child of the node becomes
	 * its initial parent's left child in order to preserve the tree's binary properties.
	 * @param node around which to rotate
	 */
	private void rightRotate(Node node) {
		if ( node == null || !(node.getParent().equals(nil)) )
			return;

		Node initialNodeParent = node.getParent();
		initialNodeParent.setLeft(node.getRight());

		if ( node.getRight() != nil ) {
			node.getRight().setParent(initialNodeParent);
		}
		node.setParent(initialNodeParent.getParent());

		if ( initialNodeParent.getParent() == nil ) {
			root = node;
		} else if ( initialNodeParent == initialNodeParent.getParent().getLeft() ) {
			initialNodeParent.getParent().setLeft(node);
		} else {
			initialNodeParent.getParent().setRight(node);
		}

		node.setRight(initialNodeParent);
		initialNodeParent.setParent(node);
	}
}
