package lib.datastructures.basic.heap;

public class MaxHeap extends AbstractHeap {

	@Override
	public void insert(int value) {
		elements[size++] = value;
		heapify();
	}

	@Override
	public int remove() {
		int max = elements[0];

		elements[0] = elements[--size];
		heapifyDown();

		return max;
	}

	private void heapify() {
		int index = size - 1;

		while (hasParent(index) && getParent(index) < elements[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;

		while (hasLeftChild(index)) {
			int biggerElementIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
				biggerElementIndex = getRightChildIndex(index);
			}

			if (elements[index] > elements[biggerElementIndex]) {
				return;
			}
			swap(index, biggerElementIndex);
			index = biggerElementIndex;
		}
	}
}
