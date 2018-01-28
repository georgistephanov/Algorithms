package lib.datastructures.trees;

import java.util.List;

public interface Tree<T> {
	TreeNode min();
	TreeNode max();
	void insert(T key);
	void delete(TreeNode node);
	List<T> inOrderTreeWalk();
}
