package Stack;

public class ArrayIntStackTest extends ArrayIntStack {

    public ArrayIntStackTest(int a){
        super(a);
    }

    public static void Popper(ArrayIntStack stack){
        try{
            stack.pop();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args){
        ArrayIntStackTest Stack = new ArrayIntStackTest(10);

        Popper(Stack);

        for(int a = 0; a < 12; a++){
            Stack.push(a);
        }
        System.out.println(Stack);

        Popper(Stack);
        Popper(Stack);
        Popper(Stack);

        System.out.println(Stack);

        Stack.clear();
        System.out.println(Stack);

        for(int a = 0; a < 22; a++){
            Stack.push(a);
        }
        System.out.println(Stack);
    }
}