package impl;

public class TestStack extends LinkedListStack {

    public static void main(String[] args){
        TestStack stack = new TestStack();

        try{
            stack.pop();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        for(int a = 1; a <= 12; a++){
            stack.push(a);
        }
        System.out.println(stack + " | Of size: " + stack.getSize());

        try{
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(stack + " | Of size: " + stack.getSize());
        stack.clear();
        System.out.println(stack + " | Of size: " + stack.getSize());

        for(int a = 10; a <= 42; a++){
            stack.push(a);
        }
        System.out.println(stack + " | Of size: " + stack.getSize());

    }
}
