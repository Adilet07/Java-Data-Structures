package impl;

import adt.Map;

public class Tester {
    public static void main(String[] args){

        Map newMap = new LLQueueMap();

        try{
            newMap.removeAny();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(newMap);

        newMap.define(11,22);newMap.define(33,44);newMap.define(55,66);
        newMap.define(77,88);newMap.define(99,100);
        System.out.println(newMap);

        newMap.remove(99);
        System.out.println(newMap);

        newMap.remove(99);
        System.out.println(newMap);

        newMap.define(55, 55);
        newMap.define(77, 66);
        System.out.println(newMap);

        newMap.define(88,99); newMap.define(100,111); newMap.define(122,133);
        System.out.println(newMap);

        for(int i = 1;  i <= 2; i++){
            try{
                System.out.println(newMap.removeAny());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
        }
        System.out.println(newMap);

        newMap.clear();
        System.out.println(newMap);

        newMap.define(11,22);
        newMap.define(33,44);
        System.out.println(newMap);
    }
}
