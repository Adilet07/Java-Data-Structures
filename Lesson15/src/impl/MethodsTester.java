package impl;

import adt.Set;

public class MethodsTester {

    public static boolean isSubset(Set<Integer> newSet1, Set<Integer> newSet2){
        boolean subSet = true;

        int s1 = newSet1.getSize();
        int s2 = newSet2.getSize();

        Set <Integer> temp1 = new LLQueueSet();
        Set <Integer> temp2 = new LLQueueSet();

        int x,y = 0;

        if(s1>s2){
            for(int i = 0; i < s2; i++){
                try{
                x = newSet2.removeAny();
                temp2.add(x);

                if(!newSet1.contains(x)){
                    subSet = false;
                    }
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

            for(int i = 0; i < s2; i++){
                try{
                    x = temp2.removeAny();
                    newSet2.add(x);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        } else {
            for(int i = 0; i < s1; i++){
                try{
                    y = newSet1.removeAny();
                    temp1.add(y);

                    if(!newSet2.contains(y)){
                        subSet = false;
                    }
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

            for(int i = 0; i < s1; i++){
                try{
                    x = temp1.removeAny();
                    newSet1.add(x);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return subSet;
    }

public static Set<String> union(Set<String> set1, Set<String> set2){

        Set <String> newSet3 = new LLQueueSet();
        Set <String> temp1 = new LLQueueSet();
        Set <String> temp2 = new LLQueueSet();

        int s1 = set1.getSize();
        int s2 = set2.getSize();

        for(int i = 0; i < s1; i++){
            try{
                String x = set1.removeAny();
                newSet3.add(x);
                temp1.add(x);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        for(int i = 0; i < s2; i++){
            try{
                String x = set2.removeAny();
                newSet3.add(x);
                temp2.add(x);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        for(int i = 0; i < s1; i++){
            try{
                String x = temp1.removeAny();
                set1.add(x);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        for(int i = 0; i < s2; i++){
            try{
                String x = temp2.removeAny();
                set2.add(x);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return newSet3;
    }

public static Set<Integer> intersection(Set<Integer> newSet1, Set<Integer> newSet2){
        Set <Integer> newSet3 = new LLQueueSet();
        Set <Integer> temp1 = new LLQueueSet();

        int s1 = newSet1.getSize();

        for(int i = 0; i < s1; i++){
            try{
                int x = newSet1.removeAny();
                temp1.add(x);

                if(newSet2.contains(x)){
                    newSet3.add(x);
                }
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        for(int i = 0; i < s1; i++){
            try{
                int x = temp1.removeAny();
                newSet1.add(x);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return newSet3;
    }

    public static void main(String[] args){

        Set<Integer> newSet1 = new LLQueueSet();
        Set<Integer> newSet2 = new LLQueueSet();

        for(int i = 0; i < 5; i++){
            newSet1.add(i);
            newSet2.add(i);
        }

        for(int i = 0; i < 5; i++){
            newSet1.add(i+5);
        }

        System.out.println(newSet1);
        System.out.println(newSet2);
        System.out.println(isSubset(newSet1,newSet2));
        System.out.println(newSet1);
        System.out.println(newSet2);
        System.out.println("_______");

        Set<String> string1 = new LLQueueSet();
        Set<String> string2 = new LLQueueSet();
        string1.add("Adilet");
        string1.add("Askerov");
        string2.add("Adil");
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(union(string1, string2));
        System.out.println(string1);
        System.out.println(string2);
        System.out.println("_______");

        System.out.println(newSet1);
        System.out.println(newSet2);
        System.out.println(intersection(newSet1, newSet2));
        System.out.println(newSet1);
        System.out.println(newSet2);
    }

}
