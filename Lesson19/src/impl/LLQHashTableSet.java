package impl;

import adt.HashTableSet;
import adt.Set;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class LLQHashTableSet<T extends Comparable> implements Set<T>, HashTableSet<T> {

    private LinkedListQueue<T>[] buckets;
    private int size;

    public LLQHashTableSet(int length){
        size = 0;
        buckets = new LinkedListQueue[length];
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            int hash = abs(value.hashCode()) % buckets.length;
            if(buckets[hash] == null){
                buckets[hash] = new LinkedListQueue();
            }
            buckets[hash].enqueue(value);
            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        int hash = abs(value.hashCode()) % buckets.length;
        if(buckets[hash] != null){
            for(int i = 0; i < buckets[hash].getSize(); i++){
                try{
                    T temp = buckets[hash].dequeue();
                    buckets[hash].enqueue(temp);
                    if(temp.equals(value))
                        return true;
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
            int hash = abs(value.hashCode()) % buckets.length;
            for(int i = 0; i < buckets[hash].getSize(); i++){
                try{
                    T temp = buckets[hash].dequeue();
                    if(value.equals(temp))
                        continue;
                    buckets[hash].enqueue(temp);
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
        } else{
            throw new Exception("Nothing to remove");
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
        String s = "";
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null && buckets[i].getSize() != 0) {
                s = s + buckets[i].toString();
                s = s + "\r\n";
            }
        }
        return s;
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(buckets[index] != null){
            return buckets[index].getSize();
        } else{
            throw new Exception ("empty bucket");
        }
    }

    @Override
    public double getLoadFactor() {
        return (double)size/(double)buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double mean = getLoadFactor();
        double sq = 0;
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null)
                sq = sq + (buckets[i].getSize() - mean)*(buckets[i].getSize() - mean);
        }
        return sqrt(sq/(double)buckets.length);
    }

    @Override
    public String bucketsToString() {
        String s = "";
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null && buckets[i].getSize() != 0) {
                s = s + buckets[i].toString();
                s = s + "\r\n";
            }
        }
        return s;
    }

}

