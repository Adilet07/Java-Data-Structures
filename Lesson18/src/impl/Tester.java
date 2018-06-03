package impl;

public class Tester {
    public static void main(String[] args){
        LLQHashTableSet<Integer> newSet = new LLQHashTableSet(10);
        try{
            newSet.removeAny();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());

        for(int i = 1; i <= 20; i++){
            newSet.add(i);
        }
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());

        for(int i = 2; i <= 20; i = i+2){
            newSet.remove(i);
        }
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());

        System.out.println(newSet.remove(10));
        System.out.println(newSet.remove(100));
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());

        for(int i = 1; i <= 30; i++){
            newSet.add(i);
        }
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());

        for(int i = 1; i <= 10; i++){
            try{
                newSet.removeAny();
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());

        newSet.clear();
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());

        for(int i = 51; i <= 79; i = i + 2){
            newSet.add(i);
        }
        System.out.println(newSet.toString() + " and the size is " + newSet.getSize());
    }
}