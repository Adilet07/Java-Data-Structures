package impl;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        HashSet<Integer> newSet = new HashSet();

        newSet.add(10);
        newSet.add(11);
        newSet.add(12);
        newSet.add(13);
        newSet.add(14);
        newSet.add(15);
        System.out.println(newSet);

        newSet.add(13);
        newSet.add(14);
        newSet.add(15);
        System.out.println(newSet);


        newSet.contains(12);
        newSet.contains(13);
        newSet.contains(22);
        newSet.contains(32);

        newSet.clear();
        System.out.println(newSet);

        newSet.add(16);
        newSet.add(17);
        newSet.add(18);
        newSet.add(19);
        System.out.println(newSet);
    }

}