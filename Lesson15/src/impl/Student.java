package impl;

public class Student {

    private int id;
    private String name;

    Student(int a, String b){
        id = a;
        name = b;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean contains(Object obj){
        if(obj instanceof Student){
            Student sobj = (Student) obj;
            return id == sobj.id && name.equals(sobj.name);
        }
        return false;
    }

    @Override
    public String toString(){
        return "Name is: " + name + ", id is: " + id;
    }
}
