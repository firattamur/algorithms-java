package org.firattamur.datastructures;

import java.util.Optional;

/**
 * A queue implementation using an array.
 *
 * @param <E> the type of the elements in the queue
 */
public class Queue<E> {

    private E[] elements;
    private int count;
    private int capacity;
    private int front;
    private int rear;

    private final static int DEFAULT_CAPACITY = 10;

    /**
     * Creates a new Queue object. The initial capacity of the queue is 10.
     */
    public Queue() {
        this.elements = createArrayWithCapacity(DEFAULT_CAPACITY);
        this.count = 0;
        this.front = 0;
        this.rear = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Inserts an element to the rear of the queue. If the queue is full, the capacity of the queue is doubled.
     *
     * @param element the element to be inserted to the queue
     */
    public void enqueue(E element) {

        if (count == capacity) {

            this.capacity *= 2;
            this.resizeArray(this.capacity);

        }

        elements[rear] = element;
        rear = (rear + 1) % elements.length;
        count++;

    }

    /**
     * Removes an element from the front of the queue.
     *
     * @return the element removed from the queue if the queue is not empty, empty optional otherwise
     */
    public Optional<E> dequeue() {

        if (isEmpty()) {
            return Optional.empty();
        }

        E removed = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        count--;

        if (count > DEFAULT_CAPACITY && count < capacity / 4) {
            this.capacity /= 2;
            this.resizeArray(this.capacity);
        }

        return Optional.of(removed);

    }

    /**
     * Peeks the front element of the queue.
     *
     * @return the front element of the queue if the queue is not empty, empty optional otherwise
     */
    public Optional<E> peek() {

        if (isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(elements[front]);
    }

    /**
     * Returns the size of the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return count;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Clears the queue.
     */
    public void clear() {
        this.elements = createArrayWithCapacity(DEFAULT_CAPACITY);
        count = 0;
        front = 0;
        rear = 0;
    }

    /**
     * Returns the capacity of the queue.
     */
    private void resizeArray(int newCapacity) {

        E[] newElements = createArrayWithCapacity(newCapacity);

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }

        elements = newElements;
        front = 0;
        rear = count;

        capacity = newCapacity;

    }

    /**
     * Creates a new array with the given capacity.
     *
     * @param capacity the capacity of the array
     * @return the new array
     */
    private E[] createArrayWithCapacity(int capacity) {
        return (E[]) new Object[capacity];
    }

}
