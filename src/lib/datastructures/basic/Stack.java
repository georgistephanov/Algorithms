package lib.datastructures.basic;

import java.util.Arrays;

public class Stack<T> {
	private static int DEFAULT_SIZE = 16;
	private T [] elements;
	private int numOfElements = 0;

	public Stack() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public Stack(int size) {
		elements = (T[]) new Object[size];
	}

	public void push(T key) {
		if (key == null) {
			return;
		}

		// If the current array is full resize it dynamically to twice its current size
		if ( numOfElements >= elements.length - 1 ) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}

		elements[numOfElements++] = key;
	}

	public T pop() {
		if (numOfElements > 0) {
			return elements[--numOfElements];
		} else {
			return null;
		}
	}

	public T top() {
		if (numOfElements > 0) {
			return elements[numOfElements - 1];
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public void empty() {
		if (numOfElements > 0) {
			elements = (T[]) new Object[DEFAULT_SIZE];
			numOfElements = 0;
		}
	}

	public boolean isEmpty() {
		return numOfElements == 0;
	}

	public int size() {
		return numOfElements;
	}
}
