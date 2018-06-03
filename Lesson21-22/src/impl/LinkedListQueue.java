package impl;

import adt.Queue;

public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> frnt;
    private Node<T> bck;
    private int siz;

    public LinkedListQueue(){
        frnt = null;
        bck = null;
        siz = 0;
    }

    @Override
    public void enqueue(T value) {

        Node<T> temp = new Node(value);

        if(siz != 0){
            bck.setLink(temp);
            bck = temp;
        } else{
            bck = temp;
            frnt = temp;
        }
        siz++;
    }

    @Override
    public T dequeue() throws Exception {
        if (siz != 0) {
            T value = frnt.getValue();
            frnt = frnt.getLink();
            if (siz == 1)
                bck = null;
            siz--;
            return value;
        } else {
            throw new Exception("Queue is empty, my friend");
        }
    }

    @Override
    public int getSize() {
        return siz;
    }

    @Override
    public void clear() {
        frnt = null;
        bck = null;
        siz = 0;
    }

    public String toString(){
        String fr = "Front [";
        String bk = "] Back";
        Node<T> tempor = frnt;
        while(tempor != null){
            fr = fr + tempor.toString() + " ";
            tempor = tempor.getLink();
        }
        return fr + bk;
    }

    @Override
    public boolean isEmpty() {
        return siz==0;
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