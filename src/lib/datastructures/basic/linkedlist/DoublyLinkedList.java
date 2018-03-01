package lib.datastructures.basic.linkedlist;

public final class DoublyLinkedList<T> implements LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public DoublyLinkedList() {
		head = new Node<>(null);
		tail = new Node<>(null);

		head.setNext(tail);
		tail.setPrev(head);
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

		return tail.getPrev();
	}

	public Node<T> at(int position) {
		if (position >= size) {
			return new Node<>(null);
		}

		Node<T> node = head.getNext();
		for (int i = 0; i < position; i++) {
			node = node.getNext();
		}

		return node;
	}

	public void insertFirst(T key) {
		Node<T> newNode = new Node<>(key, head.getNext(), head);
		head.getNext().setPrev(newNode);
		head.setNext(newNode);
		size++;
	}

	public void insertLast(T key) {
		Node<T> newNode = new Node<>(key, tail, tail.getPrev());
		tail.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		size++;
	}

	public void removeFirst() {
		if (size > 0) {
			head.getNext().getNext().setPrev(head);
			head.setNext(head.getNext().getNext());
			size--;
		}
	}

	public void removeLast() {
		if (size > 0) {
			tail.getPrev().getPrev().setNext(tail);
			tail.setPrev(tail.getPrev().getPrev());
			size--;
		}
	}

	public int size() { return size; }
}
