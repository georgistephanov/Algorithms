package lib.datastructures.basic.heap;

import java.util.Arrays;

abstract class AbstractHeap implements Heap {
	int [] elements = new int[16];
	int size = 0;

	@Override
	public abstract void insert(int value);

	@Override
	public abstract int remove();

	@Override
	public int size() { return size; }

	@Override
	public int peek() { return elements[0]; }

	void swap(int indexOne, int indexTwo) {
		int temp = elements[indexOne];
		elements[indexOne] = elements[indexTwo];
		elements[indexTwo] = temp;
	}

	public void print() { printPreOrder(0); }

	private void printPreOrder(int curr) {
		System.out.print(" " + elements[curr] + " ");

		if (hasLeftChild(curr))
			printPreOrder(getLeftChild(curr));
		if (hasRightChild(curr))
			printPreOrder(getRightChild(curr));
	}

	boolean hasParent(int index) { return index > 0; }
	boolean hasLeftChild(int index) { return index * 2 + 1 < size; }
	boolean hasRightChild(int index) { return index * 2 + 2 < size; }

	int getParentIndex(int index) { return (index - 1) / 2; }
	int getLeftChildIndex(int index) { return index * 2 + 1; }
	int getRightChildIndex(int index) { return index * 2 + 2; }

	int getParent(int index) { return elements[ (index - 1) / 2 ]; }
	int getLeftChild(int index) { return elements[ (index * 2) + 1 ]; }
	int getRightChild(int index) { return elements[ (index * 2) + 2 ]; }

	void assureArraySize() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
	}
}
