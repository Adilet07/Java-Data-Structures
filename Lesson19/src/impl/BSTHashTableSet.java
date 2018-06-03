/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.HashTableSet;
import adt.HashTableStats;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T> {

    private BSTSet<T>[] buckets;
    private int size;

    public BSTHashTableSet(int length){
        buckets = new BSTSet[length];
        size = 0;
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            int hash = abs(value.hashCode()) % buckets.length;
            if(buckets[hash] == null)
                buckets[hash] = new BSTSet();
            buckets[hash].add(value);
            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        int hash = abs(value.hashCode()) % buckets.length;
        if(buckets[hash] != null){
            return buckets[hash].contains(value);
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            int hash = abs(value.hashCode()) % buckets.length;
            buckets[hash].remove(value);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(size != 0){
            T temp = null;
            for(int i = 0; i < buckets.length; i++){
                if(buckets[i] != null && buckets[i].getSize() != 0){
                    try{
                        temp = buckets[i].removeAny();
                    } catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
            }
            size--;
            return temp;
        } else{
            throw new Exception("nothing to remove");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new BSTSet[buckets.length];
        size = 0;
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
