package impl;

import adt.Stack;

public class LinkedListStack<T> implements Stack<T> {

    private Node<T> toppone;
    private int sze;

    public LinkedListStack(){
        toppone = null;
        sze = 0;
    }

    @Override
    public void push(T value){
        if(sze!=0){
            Node previous = toppone;
            toppone = new Node(value);
            toppone.setLink(previous);
        }else{
            toppone = new Node(value);
        }
        sze++;
    }

    @Override
    public T pop() throws Exception {
        if(sze > 0){
            T temp = toppone.getValue();
            toppone = toppone.getLink();
            sze--;
            return temp;
        }else{
            throw new Exception("You cannot pop an empty stack!");
        }
    }

    @Override
    public int getSize() {
        return sze;
    }

    @Override
    public void clear() {
        toppone = null;
        sze = 0;
    }

    @Override
    public String toString() {
        String tp = "Top ";
        String bot = " Bottom";
        Node<T> tempor = toppone;
        while(tempor != null){
            tp = tp + tempor.getValue()+"  ";
            tempor = tempor.getLink();
        }
        return tp+bot;
    }
}
