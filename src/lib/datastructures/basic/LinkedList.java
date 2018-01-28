package lib.datastructures.basic;

public class LinkedList<T> {
	private Node<T> head;
	private int size = 0;

	public LinkedList() {
		head = new Node<>(null);
	}

	public Node<T> getFirst() {
		if (size == 0) {
			return new Node<>(null);
		}

		return head.getNext();
	}

	public Node<T> getLast() {
		if (size == 0) {
			return new Node<>(null);
		}

		Node<T> temp = head.getNext();
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		return temp;
	}

	public Node<T> at(int position) {

		if (position < size) {
			Node<T> temp = head.getNext();
			for (int i = 0; i < position; i++) {
				temp = temp.getNext();
			}

			return temp;
		}

		return new Node<>(null);
	}

	public void addFirst(T key) {
		Node<T> newNode = new Node<>(key);

		newNode.setNext(head.getNext());
		head.setNext(newNode);

		size++;
	}

	public void addLast(T key) {
		Node<T> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		Node<T> newNode = new Node<>(key);
		temp.setNext(newNode);

		size++;
	}

	public void deleteFirst() {
		if ( size > 0 ) {
			head = head.getNext();
			size--;
		}
	}

	public void deleteLast() {
		Node<T> temp = head;

		if (size > 1) {
			// Traverse to second to last
			while (temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}

			temp.setNext(temp.getNext().getNext());
			size--;
		} else if (size == 1) {
			head = head.getNext();
			size--;
		}
	}

	public int size() {
		return size;
	}
}
