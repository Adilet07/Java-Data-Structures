package impl;

import adt.Queue;

public class ArrayQueue<T> implements Queue<T>{

    private T[] values;
    private int size;
    private int front;
    private int back;

    public ArrayQueue() {
        values = (T[]) new Object[5];
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public void enqueue(T value) {
        if(size == values.length){
            T[] newArray = (T[]) new Object[values.length*2];

            for(int i = 0, k = front; i < size; i++, k = (k+1) % values.length) {
                newArray[i] = values[k];
            }

            values = newArray;
            front = 0;
            back = size;

        } else {
            values[back] = value;
            back = (back + 1) % values.length;
            size++;
        }
    }

    @Override
    public T dequeue() throws Exception {
        if(size!= 0){
            T result = values[front];
            values[front] = null;
            front = (front + 1) % values.length;
            size--;

            return result;
        } else {
            throw new Exception("Oops! Queue is empty!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getFront() {
        return front;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[5];
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public String toString(){
        String output = "[";

        for(int j = 0, k = front; j < size; j++, k = (k+1) % values.length){
            output += values[k] + " ";
        }

        return output + "]";
    }

}