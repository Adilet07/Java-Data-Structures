package impl;

import adt.Stack;

public class LinkedListStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public LinkedListStack(){
        top = null;
        size = 0;
    }

    @Override
    public void push(T value){
        if(size!=0){
            Node previous = top;
            top = new Node(value);
            top.setLink(previous);
        }else{
            top = new Node(value);
        }
        size++;
    }

    @Override
    public T pop() throws Exception {
        if(size > 0){
            T val = top.getValue();
            top = top.getLink();
            size--;
            return val;
        }else{
            throw new Exception("You cannot pop an empty stack!");
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
        String smthg = "Top ";
        String smthg2 = " Bottom";
        Node temp = top;
        while(temp != null){
            smthg = smthg + temp.getValue()+"  ";
            temp = temp.getLink();
        }
        return smthg+smthg2;
    }
}
