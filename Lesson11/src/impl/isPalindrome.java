package impl;

import adt.Queue;
import adt.Stack;

public class isPalindrome {


    public static boolean isPalindrome(Queue<Character> q) {

        boolean pal = true;

        Stack <Character> stack = new LinkedListStack();

        int size = q.getSize();

        for (int i = 0; i < size; i++){

            try {

                char x = q.dequeue();
                stack.push(x);
                q.enqueue(x);

            } catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

        for (int i = 0; i < size; i++){

            try {

                char x = q.dequeue();
                char y = stack.pop();

                if(x != y){
                    pal = false;

                }


                q.enqueue(x);

            } catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

        return pal;

    }

    public static void main(String[] args){

        Queue <Character> abc = new LinkedListQueue();

        abc.enqueue('A');
        abc.enqueue('S');
        abc.enqueue('T');
        abc.enqueue('a');
        abc.enqueue('S');
        abc.enqueue('A');

        System.out.println(isPalindrome(abc));
        System.out.println(abc);

    }
}
