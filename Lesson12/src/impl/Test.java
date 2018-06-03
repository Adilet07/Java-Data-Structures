package impl;

public class Test extends LinkedListSortedQueue {
    
    public static void dequeuer(LinkedListSortedQueue smthg){
        try {
                smthg.dequeue();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
    }
    
    public static void main(String[] args){
       
        Test abc = new Test();
        
        for(int i = 90; i >=10; i = i-10){
            abc.insert(i);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        for(int i = 0; i <3; i++){
            dequeuer(abc);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        for(int i = 100; i <=900; i = i+100){
            abc.insert(i);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        for(int i = 0; i <4; i++){
            dequeuer(abc);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        for(int i = 5; i <=915; i = i+10){
            abc.insert(i);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        int s = abc.getSize();
        for(int i = 0; i<s; i++){
            dequeuer(abc);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        for(int i = 5; i <=125; i = i*i){
            abc.insert(i);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        abc.clear();
        System.out.println(abc);
        System.out.println(abc.getSize());
        
        for(int i = 5; i <=20; i = i+5){
            abc.insert(i);
        }
        System.out.println(abc);
        System.out.println(abc.getSize());
    }
}