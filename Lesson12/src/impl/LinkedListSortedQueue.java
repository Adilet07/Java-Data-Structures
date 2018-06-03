package impl;

import adt.SortedQueue;

public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {

    private int size;
    private Node<T> front;

    public LinkedListSortedQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void insert(T value) {

        Node <T> newNode = new Node(value);
        Node <T> prev = null;
        Node <T> current = front;


        if (size == 0) {  //if the queue is empty
            front = newNode;
        } else {

            if (value.compareTo(front.getValue()) <= 0) {  //if the value is in the front
                newNode.setLink(front);
                front = newNode;
            } else {
                while(value.compareTo(current.getValue()) > 0 && current.getLink() != null ) {
                    prev = current;
                    current = current.getLink();
                }
                if(current.getLink() == null && value.compareTo(current.getValue()) > 0){ //at the back
                    current.setLink(newNode);
                } else { // in the middle
                    prev.setLink(newNode);
                    newNode.setLink(current);
                }
            }
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        T result = null;
        if (size != 0) {
            result = front.getValue();
            front = front.getLink();
            size--;
        } else if (size == 1) {
            result = front.getValue();
            front = null;
            size--;
        } else{
            throw new Exception("SortedQueue is empty!");
        }
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {

        front = null;
        size = 0;
    }

    @Override
    public String toString() {
        String frnt = "Front ";
        String bck = "Back";
        Node temp = front;
        while(temp != null){
            frnt = frnt + temp.getValue()+" ";
            temp = temp.getLink();
        }
        return frnt+bck;
    }
}
