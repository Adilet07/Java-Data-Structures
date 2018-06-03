package impl;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Student student) {

       String std = name;
       return std.compareTo(student.getName());

    }

    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student st = (Student) obj;
            return st.getId() == id;
        }
        return false;
    }

    public String toString(){
        return "{"+name+": "+id+"}";
    }

}