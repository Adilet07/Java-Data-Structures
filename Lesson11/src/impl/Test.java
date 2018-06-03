package impl;

public class Test extends LinkedListQueue {

    public static void dequeue(LinkedListQueue tester){
        try{
            tester.dequeue();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        Test queue1 = new Test();

        dequeue(queue1);

        for (int i = 0; i < 8; i++) {
            queue1.enqueue(i);
        }

        System.out.println(queue1);
        System.out.println(queue1.getSize());

        for (int j = 0; j < 3; j++) {
            dequeue(queue1);
        }

        System.out.println(queue1);
        System.out.println(queue1.getSize());

        for (int k = 1; k <= 9; k++) {

            queue1.enqueue(2*k);
            queue1.enqueue(2*k);

            dequeue(queue1);
            dequeue(queue1);

            System.out.println(queue1);
            System.out.println(queue1.getSize());
        }

        queue1.clear();

        System.out.println(queue1);
        System.out.println(queue1.getSize());

        for (int m = 0; m < 22; m++) {
            queue1.enqueue(m*m);
        }

        System.out.println(queue1);
        System.out.println(queue1.getSize());
    }
}
