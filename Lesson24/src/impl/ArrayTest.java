package impl;

public class ArrayTest {

    public static void main(String[] args) throws Exception {
        ArrayListStack<Integer> array = new ArrayListStack<>(15);

        try {
            array.pop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for(int i=0; i<5; i++)
            array.push(i);
        System.out.println(array.toString());

        try {
            array.pop();
            array.pop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(array + ", and size is: " +array.getSize());

        for(int i=0; i<7; i++){
            array.push(i);
        }
        System.out.println(array + ", and size is: " +array.getSize());


    }
}
