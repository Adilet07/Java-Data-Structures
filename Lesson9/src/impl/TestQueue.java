package impl;

import adt.Queue;

public class TestQueue {
    public static void main(String[] args) {

        Queue<Integer> q1 = new ArrayQueue();

        try {
            q1.dequeue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for(int i = 1; i <= 8; i++){
            q1.enqueue(i);
        }

        System.out.println("The queue: |"+ q1 + "| of size: " + q1.getSize());

        for(int i = 1; i <= 3; i++){
            try {
                q1.dequeue();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("The queue: |"+ q1 + "| of size: " + q1.getSize());

        for(int i = 1; i <= 9; i++){
            q1.enqueue(i);
            q1.enqueue(i+1);
            try {
                q1.dequeue();
                q1.dequeue();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("The queue: |"+ q1 + "| of size: " + q1.getSize());
        }

        q1.clear();
        System.out.println("The queue: |"+ q1 + "| of size: " + q1.getSize());

        for(int i = 1; i <= 22; i++){
            q1.enqueue(i);
        }

        System.out.println("The queue: |"+ q1 + "| of size: " + q1.getSize());
    }
}