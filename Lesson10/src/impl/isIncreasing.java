package impl;

import adt.Stack;

public class isIncreasing {

    public static boolean isIncreasing(Stack<Double> st) {

        Stack<Double> temp = new LinkedListStack();

        boolean result = true;
        double x = 0.0;
        double y = 0.0;
        try{
            x = st.pop();
            y = st.pop();
            temp.push(x);
            temp.push(y);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        int size = st.getSize();

        if(size >= 0){
            for(int i = 0; i < size; i++){
                if(x > y){
                    x = y;
                    try{
                        y = st.pop();
                        temp.push(y);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    result = false;
                }
            }
        }
        size = temp.getSize();

        for(int i = 0; i < size; i++){
            try{
                st.push(temp.pop());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public static void main(String[] args){
        Stack a = new LinkedListStack();
        a.push(1.2);
        a.push(1.4);
        a.push(1.4);
        a.push(1.8);
        a.push(2.0);
        System.out.println(a);
        System.out.println(isIncreasing(a));

        a.clear();

        a.push(1.6);
        a.push(1.4);
        a.push(1.2);
        a.push(1.0);
        a.push(10.0);
        System.out.println(a);
        System.out.println(isIncreasing(a));
    }
}
