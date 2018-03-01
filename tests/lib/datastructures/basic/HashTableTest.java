package lib.datastructures.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
	private HashTable<String, Integer> table = new HashTable<>();

	@Test
	public void insert() throws Exception {
		table.insert("John", 23);
		table.insert("Jane", 18);

		assertTrue(table.get("John") == 23);
		assertTrue(table.get("Jane") == 18);
	}

	@Test
	public void delete() throws Exception {
		table.insert("John", 23);
		table.insert("Jane", 18);

		assertTrue(table.get("John") == 23);
		assertTrue(table.get("Jane") == 18);

		table.delete("John");
		assertTrue(table.get("John") == null);

		table.delete("Jane");
		assertTrue(table.get("Jane") == null);
	}

	@Test
	public void get() throws Exception {
		table.insert("John", 23);
		table.insert("Jane", 18);

		assertTrue(table.get("John") == 23);
		assertTrue(table.get("Jane") == 18);
		assertTrue(table.get("David") == null);
	}
}