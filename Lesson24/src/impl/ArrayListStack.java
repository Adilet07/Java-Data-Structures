package impl;

import adt.IntStack;
import java.util.ArrayList;

public class ArrayListStack<E> implements IntStack{
    ArrayList<E> arrayList;

    public ArrayListStack(int size) {
        arrayList = new ArrayList<>(size);
    }

    @Override
    public void push(Object value) {
        arrayList.add((E) value);
    }

    @Override
    public E pop() throws Exception{
        if (arrayList.isEmpty()){
            throw new Exception("Stack is empty");
        } else {
            return arrayList.remove(getSize()-1);
        }
    }

    @Override
    public int getSize(){
        return arrayList.size();
    }

    @Override
    public void clear(){
        arrayList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }
}
