package impl;

import adt.Deque;

public class MergeFunctions {

    public static void frontpusher(LinkedListDeque temp){

        try {

            temp.popFromFront();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
    }

    public static Deque<Integer> merge (Deque<Integer> d1, Deque<Integer> d2) throws Exception {


        Deque<Integer> result = new LinkedListDeque();

        int size = 0;

        while (d1.getSize() != 0 && d2.getSize() != 0) {

            int i = 0, j = 0;

            try {

                i = d1.popFromFront();
                j = d2.popFromFront();

            } catch (Exception ex) {

                System.out.println (ex.getMessage());

            }

            if (i < j) {

                result.pushToBack(i);
                d2.pushToFront(j);

            } else {

                result.pushToBack(j);
                d1.pushToFront(i);
            }


        }

        if(d1.getSize() > d2.getSize()){
            while(d1.getSize()!=0){
                try{ result.pushToBack(d1.popFromFront());
                } catch (Exception ex) {
                    System.out.println (ex.getMessage());
                }
            }
        }
        if(d1.getSize() < d2.getSize()){
            while(d2.getSize()!=0){
                try{ result.pushToBack(d2.popFromFront());
                } catch (Exception ex) {
                    System.out.println (ex.getMessage());
                }
            }
        }

        return result;
    }

    public static Deque<Integer> mergeSort(Deque<Integer> deq) {
     /* Step 0:  base case???

        Step 1:  split deq into two Deques of relatively equal size

        Step 2:  pass both of these Deques into mergeSort


        Step 3:  pass the resulting Deques into merge, and return the result
     */
        Deque<Integer> deque = new LinkedListDeque();
        Deque<Integer> deque2 = new LinkedListDeque();
        Deque<Integer> result = new LinkedListDeque();

        if (deq.getSize() >= 2) {

            if (deq.getSize() % 2 == 1) {
                int limit = (deq.getSize() - 1) / 2;
                for (int i = 0; i < limit; i++) {
                    try {
                        deque.pushToBack(deq.popFromBack());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    try {
                        deque2.pushToFront(deq.popFromFront());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                try {
                    deque.pushToBack(deq.popFromBack());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                if (deque.getSize() > 2) {
                    deque=mergeSort(deque);

                    deque2=mergeSort(deque2);

                    try {result = merge(deque,deque2); } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    return result;
                }
            } else {
                int limit = deq.getSize() / 2;
                for (int i = 0; i < limit; i++) {
                    try {
                        deque.pushToBack(deq.popFromBack());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    try {
                        deque2.pushToFront(deq.popFromFront());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                if (deque.getSize() > 2) {
                    deque=mergeSort(deque);

                    deque2=mergeSort(deque2);

                    try {result = merge(deque,deque2); } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    return result;
                }


            }
        }else if(deq.getSize()==1){
            result = deq;
            return result;
        }

        if (deq.getSize() == 2 || deque.getSize()<=2 ) {

            try {result = merge(deque,deque2); } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        return result;
    }
}


