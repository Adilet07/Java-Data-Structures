
package impl;

import adt.HashTableSet;

public class Tester {
    public static void main(String[] args){

        HashTableSet<Student> newSet = new LLQHashTableSet(100);

        for(int i = 1; i <= 200; i++){
            newSet.add(new Student("Bob", 100+i));
        }
        System.out.println("The load factor: " + newSet.getLoadFactor());
        System.out.println("The standard Deviation: " + newSet.getBucketSizeStandardDev());

    }
}
