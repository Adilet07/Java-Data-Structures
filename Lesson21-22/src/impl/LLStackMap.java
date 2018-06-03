package impl;

import adt.Stack;
import adt.Map;

public class LLStackMap<K, V> implements Map<K, V> {

    private LinkedListStack<KeyValuePair<K,V>> lls;

    public LLStackMap(){
        lls = new LinkedListStack();
    }

    public void define(K key, V value) {

        KeyValuePair newVal = new KeyValuePair(key, value);

        if(getValue(key) != null){
            remove(key);
            lls.push(newVal);
        }else{
            lls.push(newVal);
        }
    }

    public V getValue(K key) {

        KeyValuePair indx;
        KeyValuePair second = null;

        Stack <KeyValuePair<K,V>> lltp = new LinkedListStack();

        int k=0, llsize = lls.getSize();

        while (k != llsize){
            try{
                indx = lls.pop();
                if(indx.getKey().equals(key)){
                    second = indx;
                }
                lltp.push(indx);
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
            k++;
        }

        int tk = lltp.getSize();

        while (k != tk) {
            try{
                indx = lltp.pop();
                lls.push(indx);
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
            k++;
        }
        return (V) second;
    }


    public V remove(K key) {

        KeyValuePair indx = null;
        KeyValuePair second = null;

        Stack <KeyValuePair<K,V>> lltp = new LinkedListStack();

        int k=0, llsize = lls.getSize();
        while (k != llsize) {
            try{
                indx = lls.pop();
                if(indx.getKey().equals(key)){
                    second = indx;
                }else{
                    lltp.push(indx);
                }
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
            k++;
        }

        int tk = lltp.getSize();
        while (k != tk){
            try{
                indx = lltp.pop();
                lls.push(indx);
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
            k++;
        }

        return (V) second;
    }


    public KeyValuePair<K, V> removeAny() throws Exception {

        KeyValuePair second = null;

        if(lls.getSize() == 0){
            throw new Exception("Ooops! Empty");
        }else{
            second = lls.pop();
        }
        return second;
    }


    public int getSize() {
        return lls.getSize();
    }


    public void clear() {
        lls = new LinkedListStack();
    }

    public String toString(){
        String outMsg;
        outMsg = "Content" + lls.toString() + ", with size: " + lls.getSize();
        return outMsg;
    }
}