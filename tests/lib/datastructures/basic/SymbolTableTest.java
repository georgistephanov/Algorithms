package lib.datastructures.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymbolTableTest {
	private SymbolTable<String, Integer> table = new SymbolTable<>(2);

	@Test
	public void put() throws Exception {
		assertFalse(table.contains("Georgi"));

		table.put("Georgi", 20);
		assertTrue(table.contains("Georgi"));

		table.put("Dayana", 20);
		assertTrue(table.contains("Dayana"));

		table.put("Georgi", 21);
		assertTrue(table.contains("Georgi"));
	}

	@Test
	public void get() throws Exception {
		table.put("Georgi", 20);
		table.put("Dayana", 20);

		assertTrue(table.get("Georgi") == 20);
		assertTrue(table.get("Dayana") == 20);
		assertTrue(table.get("John") == null);

		table.put("Georgi", 21);
		assertTrue(table.get("Georgi") == 21);
	}

	@Test
	public void delete() throws Exception {
		table.put("Georgi", 20);
		table.put("Dayana", 20);

		table.delete("Georgi");
		table.delete("Georgi");
		table.delete("Dayana");

		assertTrue(table.get("Georgi") == null);
		assertTrue(table.get("Dayana") == null);
	}

	@Test
	public void contains() throws Exception {
		assertFalse(table.contains("Georgi"));

		table.put("Georgi", 20);
		assertTrue(table.contains("Georgi"));

		table.put("Georgi", 25);
		assertTrue(table.contains("Georgi"));

		table.delete("Georgi");
		assertFalse(table.contains("Georgi"));
	}

	@Test
	public void isEmpty() throws Exception {
		assertTrue(table.isEmpty());

		table.put("Georgi", 21);
		table.put("Dayana", 20);
		assertFalse(table.isEmpty());

		table.delete("Georgi");
		table.delete("Dayana");
		assertTrue(table.isEmpty());
	}

}