package impl;

public class Test1 {

    public static void dequeuer(LinkedListSortedQueue smthg){
        try{
            smthg.dequeue();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main (String[] args) {

        LinkedListSortedQueue<Student> students = new LinkedListSortedQueue();

        Student mary = new Student(2015, "Mary");
        Student john = new Student(2012, "John");
        Student diana = new Student(2014, "Diana");

        students.insert(mary);
        students.insert(john);
        students.insert(diana);

        System.out.println (students);

        dequeuer(students);

        System.out.println (students);
    }
}
