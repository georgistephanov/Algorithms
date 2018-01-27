package datastructures.trees;

import lib.datastructures.trees.BinaryTree;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {
	private BinaryTree<Integer> binaryTree = new BinaryTree<>();

	@Test
	public void min() throws Exception {
		binaryTree.insert(12);
		Assert.assertTrue((Integer) binaryTree.min().getKey() == 12);

		binaryTree.insert(20);
		Assert.assertTrue((Integer) binaryTree.min().getKey() == 12);

		binaryTree.insert(4);
		Assert.assertTrue((Integer) binaryTree.min().getKey() == 4);
	}

	@Test
	public void max() throws Exception {
		binaryTree.insert(12);
		Assert.assertTrue((Integer) binaryTree.max().getKey() == 12);

		binaryTree.insert(4);
		Assert.assertTrue((Integer) binaryTree.max().getKey() == 12);

		binaryTree.insert(20);
		Assert.assertTrue((Integer) binaryTree.max().getKey() == 20);

		binaryTree.insert(8);
		Assert.assertTrue((Integer) binaryTree.max().getKey() == 20);
	}

	@Test
	public void delete() throws Exception {
		binaryTree.insert(12);
		Assert.assertTrue((Integer) binaryTree.max().getKey() == 12);

		binaryTree.insert(15);
		binaryTree.delete(binaryTree.min());
		Assert.assertTrue((Integer) binaryTree.max().getKey() == 15);

		binaryTree.delete(binaryTree.min());
		Assert.assertTrue(binaryTree.max() == null);
	}

	@Test
	public void inOrderTreeWalk() throws Exception {
		binaryTree.insert(12);
		binaryTree.insert(5);
		binaryTree.insert(18);
		binaryTree.insert(2);
		binaryTree.insert(9);
		binaryTree.insert(15);
		binaryTree.insert(13);
		binaryTree.insert(19);
		binaryTree.insert(17);

		List<Integer> inOrderTreeWalk = binaryTree.inOrderTreeWalk();
		List<Integer> sortedTree = new ArrayList<>();
		sortedTree.add(2);
		sortedTree.add(5);
		sortedTree.add(9);
		sortedTree.add(12);
		sortedTree.add(13);
		sortedTree.add(15);
		sortedTree.add(17);
		sortedTree.add(18);
		sortedTree.add(19);

		Assert.assertTrue(inOrderTreeWalk.equals(sortedTree));
	}

}