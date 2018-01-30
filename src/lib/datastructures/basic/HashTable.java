package lib.datastructures.basic;

import java.util.HashMap;
import java.util.Map;

public final class HashTable<Key, Value> {
	private static int DEFAULT_SIZE = 31;
	private Map<Key, Value> [] table;
	private int size;

	public HashTable() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.size = size;
		table = (Map<Key, Value>[]) new Map[size];

		for (int i = 0; i < size; i++) {
			table[i] = new HashMap<>();
		}
	}

	public void insert(Key key, Value value) {
		table[hash(key)].put(key, value);
	}

	public Value get(Key key) {
		return table[hash(key)].get(key);
	}

	public void delete(Key key) {
		if (table[hash(key)] != null) {
			table[hash(key)].remove(key);
		}
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}
}
