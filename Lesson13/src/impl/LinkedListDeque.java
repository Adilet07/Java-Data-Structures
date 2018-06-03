package impl;

import adt.Deque;

public class LinkedListDeque<T> implements Deque<T> {

    private int size;

    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;


    public LinkedListDeque() {

        size = 0;

        front = null;
        back = null;

    }

    @Override
    public void pushToFront(T value) {

        DoublyLinkedNode <T> temp = new DoublyLinkedNode(value);

        if (size != 0) {

            temp.setNext(front);
            front.setPrev(temp);
            front = temp;

        } else {

            front = temp;
            back = temp;
        }
        size++;
    }

    @Override
    public void pushToBack(T value) {

        DoublyLinkedNode temp = new DoublyLinkedNode(value);

        if (size != 0) {

            temp.setPrev(back);
            back.setNext(temp);
            back = temp;

        } else {

            front = temp;
            back = temp;
        }
        size++;
    }

    @Override
    public T popFromFront() throws Exception {

        if (size > 1) {

            T result = front.getValue();

            front = front.getNext();
            front.setPrev(null);

            size--;

            return result;

        } else if (size == 1) {

            T result = front.getValue();

            front = null;
            back = null;

            size--;

            return result;

        } else {

            throw new Exception ("Deque is empty!");

        }
    }

    @Override
    public T popFromBack() throws Exception {

        if (size > 1) {

            T result = back.getValue();

            back = back.getPrev();
            back.setNext(null);

            size--;

            return result;

        } else if (size == 1) {

            T result = back.getValue();

            front = null;
            back = null;

            size--;

            return result;

        } else {

            throw new Exception ("Deque is empty!");

        }
    }

    @Override
    public int getSize() {

        return size;

    }

    @Override
    public void clear() {

        size = 0;

        front = null;
        back = null;

    }

    @Override
    public String toString() {

        String string1 = "Front ";
        String string2 = " Back";

        DoublyLinkedNode temp = front;

        while (temp != null) {

            string1 = string1 + temp.getValue() + " ";

            temp = temp.getNext();

        }

        return string1 + string2;

    }
}
