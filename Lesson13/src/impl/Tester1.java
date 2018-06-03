package impl;

public class Tester1 {

    public static void frontPusher(LinkedListDeque temp){

        try {

            temp.popFromFront();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
    }

    public static void backPusher (LinkedListDeque temp) {

        try {

            temp.popFromBack();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
    }

    public static void main (String [] args) {

        LinkedListDeque<Integer> myDeque = new LinkedListDeque();

        backPusher(myDeque);
        frontPusher(myDeque);

        System.out.println(myDeque);
        System.out.println(myDeque.getSize());

        for (int i = 0; i < 5; i++) {

            myDeque.pushToFront(i*2);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int j = 0; j < 5; j++) {

            frontPusher(myDeque);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int k = 0; k < 6; k++) {

            myDeque.pushToFront(k);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int l = 0; l < 6; l ++) {

            backPusher(myDeque);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int m = 0; m < 7; m++) {

            myDeque.pushToBack(m*3);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int n = 0; n < 7; n++) {

            backPusher(myDeque);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int a = 0; a < 8; a++) {

            myDeque.pushToBack(a+3);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int b = 0; b < 8; b++) {

            frontPusher(myDeque);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int c = 1; c <= 10; c++) {

            myDeque.pushToFront(c*5);
            myDeque.pushToBack(c*3);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        for (int d = 0; d < 8; d++) {

            frontPusher(myDeque);
            backPusher(myDeque);

            System.out.println(myDeque);
            System.out.println(myDeque.getSize());
        }

        myDeque.clear();

        System.out.println(myDeque);
        System.out.println(myDeque.getSize());

        myDeque.pushToBack(5);
        myDeque.pushToFront(2545);
        myDeque.pushToFront(4589);
        myDeque.pushToBack(866);

        System.out.println(myDeque);
        System.out.println(myDeque.getSize());
    }


}
