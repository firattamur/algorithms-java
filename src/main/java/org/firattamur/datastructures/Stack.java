package org.firattamur.datastructures;

import java.util.ArrayList;

public class Stack<E> {

    private final ArrayList<E> stackList;
    private int topIndex;

    public Stack() {
        stackList = new ArrayList<E>();
        topIndex = -1;
    }

    public void push(E element) {

        this.stackList.add(element);
        topIndex += 1;

    }

    public E pop() {

        if (topIndex < 0) {
            return null;
        }

        E removed = this.stackList.remove(this.topIndex);
        topIndex -= 1;

        return removed;

    }

    public E peek() {

        if (topIndex < 0) {
            return null;
        }

        return this.stackList.get(this.topIndex);

    }

    public int size() {
        return this.topIndex + 1;
    }

    public Boolean isEmpty() {
        return this.topIndex == -1;
    }

}
