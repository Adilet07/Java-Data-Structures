package impl;

import adt.Stack;

public class TestStack {

    public static void main(String[] args){

        Stack<Integer> Stack = new ArrayStack(10);

        for(int a = 0; a < 12; a++){
            Stack.push(a);
        }
        System.out.println(Stack);

        try {
            Stack.pop();
        } catch (Exception ex) {
            System.out.println("Ooops!");
        }

        System.out.println(Stack);

        Stack.clear();

        System.out.println(Stack);

        for(int a = 0; a < 22; a++){
            Stack.push(a);
        }
        System.out.println(Stack);
    }
}
