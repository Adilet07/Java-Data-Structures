package impl;
import java.util.TreeMap;


public class MapTest {
    public static void main(String[] args) throws Exception {
        TreeMap<Integer, String> newMap = new TreeMap();
        newMap.put(12,"abc");
        newMap.put(23,"def");
        newMap.put(34,"ghi");
        newMap.put(45,"jkl");
        newMap.put(56,"mno");
        System.out.println(newMap+ ", and the size is:" + newMap.size());

        newMap.remove(45);
        newMap.remove(67);

        newMap.put(12, "first");
        newMap.put(23, "second");
        System.out.println(newMap+ ", and the size is:" + newMap.size());

        newMap.clear();
        System.out.println("clear " + newMap+ ", size:" + newMap.size());

        newMap.put(0, "one");
        newMap.put(2, "three");
        System.out.println("two new mappings " + newMap+ ", size:" + newMap.size());


    }



}
