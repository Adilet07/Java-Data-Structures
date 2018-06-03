package impl;

import adt.Queue;

public class LinkedListQueue<T> implements Queue<T>{

    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedListQueue () {
        front = null;
        back = null;
        size = 0;
    }
    @Override
    public void enqueue(T value) {

        if (size != 0) {

            Node<T> temp = new Node(value);

            back.setLink(temp);
            back = temp;

        } else {

            Node<T> temp = new Node(value);
            back = temp;
            front = temp;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {

        T result = null;

        if (size != 0 && size != 1) {

            result = front.getValue();
            front = front.getLink();

            size--;

        } else if(size == 1) {

            result = front.getValue();
            front = null;
            back = null;
            size--;

        } else {
            throw new Exception("Queue is empty!");
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
        back = null;
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
