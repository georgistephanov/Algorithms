package lib.datastructures.basic.linkedlist;

public final class Node<T> {
	private final T key;
	private Node<T> next;
	private Node<T> prev;

	Node(T key) {
		this(key, null, null);
	}

	public Node(T key, Node<T> next) {
		this(key, next, null);
	}

	Node(T key, Node<T> next, Node<T> prev) {
		this.key = key;
		this.next = next;
		this.prev = prev;
	}

	public T getKey() {
		return key;
	}

	Node<T> getNext() {
		return next;
	}

	void setNext(Node next) {
		this.next = next;
	}

	Node<T> getPrev() {
		return prev;
	}

	void setPrev(Node prev) {
		this.prev = prev;
	}
}
