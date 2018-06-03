package Stack;

import java.util.Arrays;

public class ArrayIntStack implements IntStack {

    private int[] values;
    private int size;
    private int b;

    public ArrayIntStack(int a){
        b = a;
        values = new int[b];
        size = 0;
    }

    @Override
    public void push(int value) {
        if(size == values.length){
            values = Arrays.copyOf(values, size*2);
        }
        values[size] = value;
        size++;
    }

    @Override
    public int pop() throws Exception {
        if (size > 0){
            int result = values[size-1];
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
        values = new int[b];
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