package impl;

import adt.Set;

public class QueueSetTester {
    public static void main(String[] args){

        Set<Student> newSet = new LLQueueSet();

        try{
            newSet.removeAny();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(newSet);
        System.out.println(newSet.getSize());

        Student student1 = new Student(1, "Adilet");
        Student student2 = new Student(2, "Askerov");
        Student student3 = new Student(3, "Adil");
        Student student4 = new Student(4, "Adilbek");
        Student student5 = new Student(5, "Adilgazy");
        Student student6 = new Student(6, "Adiladil");
        Student student7 = new Student(7, "Telida");

        newSet.add(student1);
        newSet.add(student2);
        newSet.add(student3);
        newSet.add(student4);
        newSet.add(student5);

        System.out.println(newSet);
        System.out.println(newSet.getSize());

        newSet.remove(student1);
        newSet.remove(student1);
        System.out.println(newSet);
        System.out.println(newSet.getSize());

        newSet.add(student6);
        newSet.add(student7);
        System.out.println(newSet);
        System.out.println(newSet.getSize());

        Student student8 = new Student(8, "Asker");
        Student student9 = new Student(9, "Adi");
        Student student10 = new Student(10, "Reksa");

        newSet.add(student8);
        newSet.add(student9);
        newSet.add(student10);
        System.out.println(newSet);
        System.out.println(newSet.getSize());

        try{
            System.out.println(newSet.removeAny());
            System.out.println(newSet.removeAny());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(newSet);
        System.out.println(newSet.getSize());

        newSet.clear();
        System.out.println(newSet);
        System.out.println(newSet.getSize());

        newSet.add(student1);
        newSet.add(student2);
        System.out.println(newSet);
        System.out.println(newSet.getSize());
    }

}
