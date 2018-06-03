package impl;

import adt.Queue;

public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedListQueue(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {

        Node<T> temp = new Node(value);

        if(size != 0){
            back.setLink(temp);
            back = temp;
        } else{
            back = temp;
            front = temp;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size != 0) {
            T value = front.getValue();
            front = front.getLink();
            if (size == 1)
                back = null;
            size--;
            return value;
        } else {
            throw new Exception("Queue is empty, my friend");
        }
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

    public String toString(){
        String fr = "Front [";
        String bk = "] Back";
        Node<T> temp = front;
        while(temp != null){
            fr = fr + temp.toString() + " ";
            temp = temp.getLink();
        }
        return fr + bk;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(T value) {
        T temp;

        int s = getSize();
        for (int i = 0; i < s; i++) {
            try {
                temp = dequeue();
                enqueue(temp);

                if(temp == value){
                    return true;
                }

            } catch (Exception msg) {
                System.out.println("Error has occured");
            }
        }
        return false;

    }

    @Override
    public boolean remove(T value) {
        if(!contains(value)) {
            return false;
        }

        T temp;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            try {
                temp = dequeue();

                if(temp == value){
                    return true;
                }
                enqueue(temp);

            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }

        return false;

    }

}