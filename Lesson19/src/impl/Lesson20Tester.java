package impl;

import adt.HashTableSet;

import java.util.Random;

public class Lesson20Tester {
    public static void main(String[] args) {

        Random rand = new Random();

        HashTableSet<Integer> newSet = new LLQHashTableSet(5000);

        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            newSet.add(rand.nextInt());
        }

        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);
        System.out.println("The load factor: " + newSet.getLoadFactor());
        System.out.println("The standard Deviation: " + newSet.getBucketSizeStandardDev());
    }
}
