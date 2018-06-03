package impl;

import java.util.Arrays;
import adt.Stack;

public class ArrayStack<T> implements Stack<T> {

    private T[] values;
    private int size;
    private int b;

    public ArrayStack(int a){
        b = a;
        values = (T[]) new Object[b];
        size = 0;
    }

    @Override
    public void push(T value) {
        if(size == values.length){
            values = Arrays.copyOf(values, size*2);
        }
        values[size] = value;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size > 0){
            T result = values[size-1];
            size--;
            return result;
        } else {
            throw new Exception("You cannot pop from empty array");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[b];
        size = 0;
    }

    public String toString(){
        System.out.print("Top[");
        for(int a = 0; a < size; a++){
            if (a+1 < size){
                System.out.print(values[a] + ", ");
            } else{
                System.out.print(values[a]);
            }
        }
        return "]Bottom";
    }
}