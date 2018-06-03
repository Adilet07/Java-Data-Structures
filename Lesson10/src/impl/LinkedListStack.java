package impl;

import adt.Stack;

public class LinkedListStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public LinkedListStack(){
        top = null;
        size = 0;
    }

    public void push (T value) {
        if(size!=0){
            Node previous = top;
            top = new Node(value);
            top.setLink(previous);
        }else{
            top = new Node(value);
        }
        size++;
    }

    public T pop () throws Exception {
        if(size > 0){
            T result = top.getValue();
            top = top.getLink();
            size--;
            return result;
        }else{
            throw new Exception("You cannot pop from an empty stack!");
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        String topM = "Top [ ";
        String bottom = "] Bottom";
        Node temp = top;
        while(temp != null){
            topM = topM + temp.getValue() + "  ";
            temp = temp.getLink();
        }
        return topM+bottom;
    }
}
