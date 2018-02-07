package lib.datastructures.basic;

public interface LinkedList<T> {
	Node<T> getFirst();
	Node<T> getLast();
	Node<T> at(int position);
	void insertFirst(T key);
	void insertLast(T key);
	void removeFirst();
	void removeLast();
	int size();
}