package impl;

import adt.Set;

public class StudentTest {
    public static void main(String[] args){
        Set<Student> students = new BSTSet();


        students.add(new Student(1,"Adilet"));
        students.add(new Student(3,"Adilbek"));
        students.add(new Student(15,"Adilgazy"));
        students.add(new Student(122,"Adilzhan"));
        students.add(new Student(11,"Adilida"));
        System.out.println(students + " Size is:" + students.getSize());

        students.add(new Student(53,"Adilbay"));
        students.add(new Student(14,"Bekadil"));
        System.out.println(students + " Size is:" + students.getSize());

        students.add(new Student(44,"Adilet"));
        students.add(new Student(35,"Adilbay"));
        students.add(new Student(52,"Askerov"));
        System.out.println(students + " Size is:" + students.getSize());

        students.clear();
        System.out.println(students + " Size is:" + students.getSize());

        students.add(new Student(12,"Adilet"));
        students.add(new Student(32,"Askerov"));
        System.out.println(students + " Size is:" + students.getSize());
    }
}
