package lib.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndStringsTest {

	@Test
	public void compress() throws Exception {
		String initialString = "aabcccccaaa";
		String result = "a2b1c5a3";
		assertEquals(ArraysAndStrings.compress(initialString), result);

		String returnSameString = "abbccd";
		assertEquals(ArraysAndStrings.compress(returnSameString), returnSameString);

		// Special cases
		assertNull(ArraysAndStrings.compress(null));
		assertEquals(ArraysAndStrings.compress(""), "");
	}

	@Test
	public void isOneOperationOf() throws Exception {
		String initialString = "pale";

		// Successful
		String test1 = "ple";
		String test2 = "pales";
		String test3 = "parle";
		String test4 = "bale";

		// Unsuccessful
		String test5 = "bake";
		String test6 = "pale";

		assertTrue(ArraysAndStrings.isOneOperationOf(initialString, test1));
		assertTrue(ArraysAndStrings.isOneOperationOf(initialString, test3));
		assertTrue(ArraysAndStrings.isOneOperationOf(initialString, test4));

		assertFalse(ArraysAndStrings.isOneOperationOf(initialString, test5));
		assertFalse(ArraysAndStrings.isOneOperationOf(initialString, test6));
	}
}