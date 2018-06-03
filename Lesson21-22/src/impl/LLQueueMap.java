package impl;

import adt.Map;

public class LLQueueMap<K, V> implements Map<K, V> {

    private LinkedListQueue<KeyValuePair<K,V>> llqs;

    public LLQueueMap(){
        llqs = new LinkedListQueue();
    }

    public void define(K key, V value) {

        KeyValuePair newVal = new KeyValuePair(key, value);

        if(getValue(key) != null) {
            remove(key);
            llqs.enqueue(newVal);
        } else
            llqs.enqueue(newVal);
    }

    public V getValue(K key) {

        KeyValuePair abc;
        KeyValuePair second = null;

        int k = 0, llsize = llqs.getSize();
        while (k != llsize){
            try{
                abc = llqs.dequeue();
                if(abc.getKey().equals(key)){
                    second = abc;
                }
                llqs.enqueue(abc);
            } catch (Exception exc){
                System.out.println(exc.getMessage());
            }
            k++;
        }
        return (V) second;
    }

    public V remove(K key) {
        KeyValuePair abc = null;

        int k = 0, llsize = llqs.getSize();

        while (k != llsize) {
            try{
                abc = llqs.dequeue();

            } catch (Exception exc){
                System.out.println(exc.getMessage());
            }
            if(abc.getKey().equals(key)){
                return (V) abc;
            }
            llqs.enqueue(abc);
            k++;
        }

        return (V) abc;
    }

    public KeyValuePair<K, V> removeAny() throws Exception {

        KeyValuePair abcd = null;

        if(llqs.getSize() == 0){
            throw new Exception("Oops! Empty map");
        } else {
            abcd = llqs.dequeue();
        }
        return abcd;
    }

    public int getSize() {
        return llqs.getSize();
    }

    public void clear() {
        llqs = new LinkedListQueue();
    }

    public String toString(){
        String outMsg;
        outMsg = "Content:" + llqs.toString() + ", with size: " + llqs.getSize();
        return outMsg;
    }
}
