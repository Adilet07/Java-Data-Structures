package impl;

import adt.Queue;
import adt.Set;

public class LLQueueSet<T> implements Set<T> {

    private LinkedListQueue<T> newItem;

    public LLQueueSet(){
        newItem = new LinkedListQueue<>();
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            newItem.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        for(int i = 0; i < newItem.getSize(); i++){
            try{
                T x = newItem.dequeue();
                newItem.enqueue(x);
                if(x.equals(value)){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("You cannot remove from empty set!");
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value){
        if(contains(value)){
            Queue<T> out = new LinkedListQueue();
            T current = null;
            try {
                current = newItem.dequeue();
            }catch (Exception ex) {
                System.out.println("Queue is empty!");
            }
            while(!value.equals(current)){
                out.enqueue(current);
                try {
                    current = newItem.dequeue();
                } catch (Exception ex) {
                    System.out.println("Queue is empty!");
                }
            }
            int size = out.getSize();
            for(int i=0; i<size; i++ ){
                try {
                    newItem.enqueue(out.dequeue());
                } catch (Exception ex) {
                    System.out.println("Queue is empty!");
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
            result = newItem.dequeue();
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

    public String toString(){
        return newItem.toString();
    }
}