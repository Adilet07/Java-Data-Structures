package impl;

public class Student implements Comparable {

    private int id;
    private String name;

    public Student(int value, String name) {
        id = value;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object student) {

        Student st = (Student) student;
        boolean res = id > st.getID();
        if(res == false) return -1;
        else return 1;
        //       return name.compareTo(st.getName());
    }

    @Override
    public String toString() {
        return "Student " + name + " with id " + id;
    }
}
