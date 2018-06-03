package impl;

import adt.Deque;
import static impl.MergeFunctions.merge;
import static impl.MergeFunctions.mergeSort;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        Deque<Integer> d1 = new LinkedListDeque();
        Deque<Integer> d2 = new LinkedListDeque();

        Deque<Integer> tester = new LinkedListDeque();
        Deque<Integer> tester2 = new LinkedListDeque();

        for (int i = 0; i < 3; i++) {

            d1.pushToBack(2*i+1);
            d2.pushToBack(2*i+2);
        }

        tester = merge(d1, d2);

        System.out.println(tester);
        System.out.println(tester.getSize());



        System.out.println(mergeSort(tester));

    }
}
