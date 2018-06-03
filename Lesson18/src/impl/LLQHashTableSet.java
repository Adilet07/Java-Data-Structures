package impl;

import adt.Set;
import static java.lang.Math.abs;

public class LLQHashTableSet<T extends Comparable> implements Set<T> {

    private LinkedListQueue<T>[] buckets;
    private int size;

    public LLQHashTableSet(int leng){
        size = 0;
        buckets = new LinkedListQueue[leng];
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            int hashItem = abs(value.hashCode()) % buckets.length;

            if(buckets[hashItem] == null){
                buckets[hashItem] = new LinkedListQueue();
            }

            buckets[hashItem].enqueue(value);
            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        int hashItem = abs(value.hashCode()) % buckets.length;

        if(buckets[hashItem] != null){

            for(int i = 0; i < buckets[hashItem].getSize(); i++){
                try {
                    T temp = buckets[hashItem].dequeue();
                    buckets[hashItem].enqueue(temp);

                    if (temp.equals(value)){
                        return true;
                    }
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            int hashItem = abs(value.hashCode()) % buckets.length;
            for(int i = 0; i < buckets[hashItem].getSize(); i++){
                try{
                    T temp = buckets[hashItem].dequeue();
                    if(value.equals(temp))
                        continue;
                    buckets[hashItem].enqueue(temp);
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(size != 0){
            T temp = null;
            for (int i = 0; i < buckets.length; i++) {

                if(buckets[i] != null && buckets[i].getSize() != 0){
                    try{
                        temp = buckets[i].dequeue();
                    } catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
            }
            size--;
            return temp;
        } else {
            throw new Exception("Empty!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        buckets = (LinkedListQueue<T>[])new LinkedListQueue[buckets.length];
    }

    public String toString(){
        String str = " ";
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null && buckets[i].getSize() != 0) {
                str = str + buckets[i].toString();
                str = str + "\r\n";
            }
        }
        return str;
    }

}

