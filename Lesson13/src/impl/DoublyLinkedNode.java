package impl;

import adt.Deque;

public class DoublyLinkedNode<T> {

    private T value;

    private DoublyLinkedNode<T> prev;
    private DoublyLinkedNode<T> next;

    public DoublyLinkedNode(T val) {
        prev = null;
        next = null;
        value = val;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T val) {
        value = val;
    }

    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    public DoublyLinkedNode<T> getPrev() {
        return prev;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoublyLinkedNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
