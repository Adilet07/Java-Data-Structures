package impl;

import adt.Set;
import adt.Stack;

public class LLStackSet<T> implements Set <T> {

    private LinkedListStack<T> newItem;

    public LLStackSet(){
        newItem = new LinkedListStack<>();
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            newItem.push(value);
        }
    }

    @Override
    public boolean contains(T value) {
        Stack <T> temp = new LinkedListStack();
        int size = newItem.getSize();
        for(int i = 0; i < size; i++){
            try{
                T x = newItem.pop();
                temp.push(x);
                if(x.equals(value)){
                    int tsize = temp.getSize();
                    for(int j = 0; j < tsize; j++){
                        try{
                            newItem.push(temp.pop());
                        }catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    return true;
                }else if(newItem.getSize() == 0){
                    int tsize = temp.getSize();
                    for(int j = 0; j < tsize; j++){
                        try{
                            newItem.push(temp.pop());
                        }catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            }catch(Exception ex){
                System.out.println("You cannot remove from empty set!");
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            Stack<T> out = new LinkedListStack();
            T current = null;
            try {
                current = newItem.pop();
            }catch (Exception ex) {
                System.out.println("Cannot dequeue an empty queue!");
            }
            while(!value.equals(current)){
                out.push(current);
                try {
                    current = newItem.pop();
                } catch (Exception ex) {
                    System.out.println("Cannot dequeue an empty queue!");
                }
            }
            int size = out.getSize();
            for(int i=0; i<size; i++ ){
                try {
                    newItem.push(out.pop());
                } catch (Exception ex) {
                    System.out.println("Cannot dequeue an empty queue!");
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public T removeAny() throws Exception {
        T result = null;
        if(newItem.getSize()==0){
            throw new Exception("You cannot remove from an empty set!");
        }else{
            result = newItem.pop();
        }
        return result;
    }

    @Override
    public int getSize() {
        return newItem.getSize();
    }

    @Override
    public void clear() {
        newItem.clear();
    }

    @Override
    public String toString() {
        return newItem.toString();
    }
}