package com.fasterxml.jackson.databind.util;

public final class LinkedNode<T> {
    private LinkedNode<T> next;
    private final T value;

    public LinkedNode(T value2, LinkedNode<T> next2) {
        this.value = value2;
        this.next = next2;
    }

    public void linkNext(LinkedNode<T> n) {
        if (this.next == null) {
            this.next = n;
            return;
        }
        throw new IllegalStateException();
    }

    public LinkedNode<T> next() {
        return this.next;
    }

    public T value() {
        return this.value;
    }
}
