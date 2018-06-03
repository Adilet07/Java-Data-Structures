package impl;

public class Student implements Comparable<Student> {

    private int id;
    private String name;

    public Student(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student sobj = (Student) obj;
            return id == sobj.id && name.equals(sobj.name);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + id + "]";
    }

    @Override
    public int compareTo(Student t) {
        Integer i = id;
        String s = name;
        if(s.compareTo(t.getName()) == 0){
            return i.compareTo(t.getId());
        }else{
            return s.compareTo(t.getName());
        }
    }
}
