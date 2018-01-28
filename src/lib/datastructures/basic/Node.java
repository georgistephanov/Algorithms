package lib.datastructures.basic;

public final class Node<T> {
	private final T key;
	private Node<T> next;
	private Node<T> prev;

	public Node(T key) {
		this(key, null, null);
	}

	public Node(T key, Node<T> next) {
		this(key, next, null);
	}

	public Node(T key, Node<T> next, Node<T> prev) {
		this.key = key;
		this.next = next;
		this.prev = prev;
	}

	public T getKey() {
		return key;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
