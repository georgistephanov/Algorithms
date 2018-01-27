package datastructures.basic;

import lib.datastructures.basic.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
	private Stack<Integer> stack = new Stack<>(5);

	@Test
	public void push() throws Exception {
		stack.push(10);
		assertTrue(stack.top() == 10);

		stack.push(15);
		assertTrue(stack.top() == 15);
	}

	@Test
	public void pop() throws Exception {
		stack.push(10);
		stack.push(15);

		assertTrue(stack.pop() == 15);
		assertTrue(stack.pop() == 10);
		assertTrue(stack.pop() == null);
	}

	@Test
	public void top() throws Exception {
		assertTrue(stack.top() == null);

		stack.push(10);
		assertTrue(stack.top() == 10);

		stack.push(15);
		assertTrue(stack.top() == 15);
	}

	@Test
	public void empty() throws Exception {
		stack.push(10);
		stack.push(15);

		assertTrue(stack.size() > 0);

		stack.empty();

		assertTrue(stack.size() == 0);
	}

	@Test
	public void isEmpty() throws Exception {
		assertTrue(stack.isEmpty());

		stack.push(10);

		assertFalse(stack.isEmpty());
	}

	@Test
	public void size() throws Exception {
		assertTrue(stack.size() == 0);

		stack.push(10);
		assertTrue(stack.size() == 1);

		stack.push(15);
		stack.push(20);
		stack.push(20);
		assertTrue(stack.size() == 4);
	}
}