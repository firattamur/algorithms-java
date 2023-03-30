package org.firattamur.datastructures;

import org.junit.Test;

public class StackTest {

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testStackPush() {
        Stack<Integer> stack = new Stack<>();
        int expectedPeek = 1;

        stack.push(expectedPeek);

        assert stack.peek() == expectedPeek;
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testStackPop() {
        Stack<Integer> stack = new Stack<>();
        int expectedPop = 1;

        stack.push(1);
        int pop = stack.pop();

        assert pop == expectedPop;
    }

    /**
     * Test of peek method, of class Stack.
     * case: stack is not empty
     */
    @Test
    public void testStackPeek() {
        Stack<Integer> stack = new Stack<>();
        int expectedPeek = 1;

        stack.push(expectedPeek);

        assert stack.peek() == expectedPeek;
    }

    /**
     * Test of peek method, of class Stack.
     * case: stack is empty
     */
    @Test
    public void testStackPeekWhileEmpty() {
        Stack<Integer> stack = new Stack<>();

        // No Act

        assert stack.peek() == null;
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testStackSize() {
        Stack<Integer> stack = new Stack<Integer>();
        int expectedSize = 5;

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assert stack.size() == expectedSize;
    }

    /**
     * Test of isEmpty method, of class Stack.
     * case: stack is empty
     */
    @Test
    public void testStackIsEmptyWhileEmpty() {
        Stack<Integer> stack = new Stack<>();

        // No Act

        assert stack.isEmpty();
    }

    /**
     * Test of isEmpty method, of class Stack.
     * case: stack is not empty
     */
    @Test
    public void testStackIsEmptyWhileNotEmpty() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);

        assert !stack.isEmpty();
    }


}
