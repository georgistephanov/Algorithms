package lib.datastructures.trees;

import java.util.List;

public final class RedBlackTree<T extends Comparable<? super T>> extends AbstractTree<T> {
	private final TreeNode<T> nil = new TreeNode<T>(null);

	public RedBlackTree() {
		root.setParent(nil);
	}

	@Override
	public void insert(T key) {

	}

	@Override
	public void delete(TreeNode node) {

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
	private void leftRotate(TreeNode node) {
		if ( node == null || !(node.getRight().equals(nil)) )
			return;

		TreeNode initialRightChild = node.getRight() != null ? node.getRight() : new TreeNode<T>(null);
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
	private void rightRotate(TreeNode node) {
		if ( node == null || !(node.getParent().equals(nil)) )
			return;

		TreeNode initialNodeParent = node.getParent();
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
