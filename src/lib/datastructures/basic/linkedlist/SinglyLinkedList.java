package lib.datastructures.basic.linkedlist;

public final class SinglyLinkedList<T> implements LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public SinglyLinkedList() {
		head = new Node<>(null);
		tail = head;
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

		return tail;
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

	public void insertFirst(T key) {
		Node<T> newNode = new Node<>(key);

		newNode.setNext(head.getNext());
		head.setNext(newNode);

		// Set this element as the tail if it is the first element inserted
		if (size == 0) {
			tail = newNode;
		}

		size++;
	}

	public void insertLast(T key) {
		Node<T> newNode = new Node<>(key);
		tail.setNext(newNode);
		tail = newNode;

		size++;
	}

	public void removeFirst() {
		if ( size > 0 ) {
			head = head.getNext();
			size--;
		}
	}

	public void removeLast() {
		Node<T> temp = head;

		if (size > 1) {
			// Traverse to second to last
			while (temp.getNext() != tail) {
				temp = temp.getNext();
			}

			temp.setNext(tail.getNext());
			tail = temp;
			size--;
		} else if (size == 1) {
			head = tail = head.getNext();
			size--;
		}
	}

	public int size() {
		return size;
	}
}
