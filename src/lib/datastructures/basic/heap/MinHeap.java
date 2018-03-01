package lib.datastructures.basic.heap;

public class MinHeap extends AbstractHeap {

	public void insert(int value) {
		assureArraySize();

		elements[size++] = value;
		heapify();
	}

	public int remove() {
		if (size == 0) {
			return -1;
		}

		int min = elements[0];

		elements[0] = elements[--size];
		heapifyDown();

		return min;
	}

	private void heapify() {
		int index = size - 1;
		while (hasParent(index) && getParent(index) > elements[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;

		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && elements[smallerChildIndex] > getRightChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}

			if (elements[index] < elements[smallerChildIndex]) {
				return;
			}

			swap(index, smallerChildIndex);
			index = smallerChildIndex;
		}
	}
}
