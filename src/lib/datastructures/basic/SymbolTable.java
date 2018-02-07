package lib.datastructures.basic;

import java.util.Arrays;

public class SymbolTable<K extends Comparable, V> {
	private K [] keys;
	private V [] values;
	private int current = 0;

	public SymbolTable() {
		this(16);
	}

	@SuppressWarnings("unchecked")
	public SymbolTable(int size) {
		keys = (K[]) new Comparable[size];
		values = (V[]) new Object[size];
	}

	public void put(K key, V value) {
		if (current == keys.length) {
			resize();
		}

		for (int i = 0; i < current; i++) {
			if (keys[i] == key) {
				values[i] = value;
				return;
			}
		}

		keys[current] = key;
		values[current++] = value;
	}

	public V get(K key) {
		for (int i = 0; i < current; i++) {
			if (keys[i] == key) {
				return values[i];
			}
		}

		return null;
	}

	public void delete(K key) {
		for (int i = 0; i < current; i++) {
			if (keys[i] == key) {
				values[i] = null;
				return;
			}
		}
	}

	public boolean contains(K key) {
		for (int i = 0; i < current; i++) {
			if (keys[i] == key) {
				return values[i] != null;
			}
		}

		return false;
	}

	public boolean isEmpty() {
		for (int i = 0; i < current; i++) {
			if (values[i] != null)
				return false;
		}

		return true;
	}

	private void resize() {
		keys = Arrays.copyOf(keys, keys.length * 2);
		values = Arrays.copyOf(values, values.length * 2);
	}
}
