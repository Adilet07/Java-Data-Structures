package Impl;

import ADT.IntQueue;

public class ArrayIntQueue implements IntQueue{

    private int[] values;
    private int size;
    private int front;
    private int back;

    public ArrayIntQueue() {
        values = new int[5];
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public void enqueue(int value) {
        if(size == values.length){
            int[] newArray = new int[values.length*2];

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
    public int dequeue() throws Exception {
        if(size!= 0){
            int result = values[front];
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
        values = new int[5];
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
