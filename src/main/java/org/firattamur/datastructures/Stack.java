package org.firattamur.datastructures;

import java.util.Optional;

public class Stack<E> {

    private E[] elements;
    private int count;
    private int capacity;
    private int top;
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * Creates a new Stack object with an initial capacity of 10.
     */
    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates a new Stack object with the given initialCapacity.
     *
     * @param initialCapacity the initial initialCapacity of the stack
     */
    public Stack(int initialCapacity) {
        this.elements = createArrayWithCapacity(initialCapacity);
        this.count = 0;
        this.top = 0;
        this.capacity = initialCapacity;
    }


    /**
     * Pushes an element to the top of the stack.
     *
     * @param element the element to be pushed
     */
    public void push(E element) {

        if (this.count == this.capacity) {
            this.capacity *= 2;
            this.resizeArray(this.capacity);
        }

        this.elements[top] = element;
        this.top++;
        this.count++;

    }

    /**
     * Pops an element from the top of the stack.
     *
     * @return the element popped from the stack
     */
    public Optional<E> pop() {

        if (isEmpty()) {
            return Optional.empty();
        }

        E popped = this.elements[top - 1];
        this.elements[top - 1] = null;

        this.top--;
        this.count--;

        if (this.count > DEFAULT_CAPACITY && this.count < this.capacity / 4) {
            this.capacity /= 2;
            this.resizeArray(this.capacity);
        }

        return Optional.of(popped);
    }

    /**
     * Peeks the top element of the stack.
     *
     * @return the top element of the stack
     */
    public Optional<E> peek() {

        if (isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(this.elements[top - 1]);

    }

    /**
     * Returns the size of the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return this.count;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public Boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Clears the stack.
     */
    public void clear() {
        this.elements = createArrayWithCapacity(DEFAULT_CAPACITY);
        this.count = 0;
        this.top = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Resizes the array to given newCapacity.
     *
     * @param newCapacity the new capacity of the array
     */
    private void resizeArray(int newCapacity) {

        E[] newElements = createArrayWithCapacity(newCapacity);

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);

        this.elements = newElements;
        this.capacity = this.elements.length;

    }

    /**
     * Creates a new array with the given capacity.
     */
    private E[] createArrayWithCapacity(int capacity) {
        return (E[]) new Object[capacity];
    }

}
