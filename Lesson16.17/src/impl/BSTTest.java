package impl;

import adt.Set;

public class BSTTest {
    public static void main(String[] args){
        //Set<Integer> bsTree = new BSTSet();
        Set<Integer> bsTree = new BST2Set();

        bsTree.add(5);
        bsTree.add(12);
        bsTree.add(3);
        bsTree.add(6);
        bsTree.add(14);
        bsTree.add(2);
        bsTree.add(-6);
        bsTree.add(8);
        bsTree.add(0);
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        bsTree.add(14);
        bsTree.add(-6);
        bsTree.add(5);
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        System.out.println(bsTree.contains(12));
        System.out.println(bsTree.contains(7));
        System.out.println(bsTree.contains(2));
        System.out.println(bsTree.contains(-8));
        System.out.println(bsTree.contains(5));
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        bsTree.remove(0);
        bsTree.remove(6);
        bsTree.remove(3);
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        bsTree.add(6);
        bsTree.add(13);
        bsTree.add(99);
        bsTree.add(11);
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        bsTree.remove(12);
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        bsTree.remove(5);
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        try{
            bsTree.removeAny();
            bsTree.removeAny();
            bsTree.removeAny();
            System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        bsTree.clear();
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());

        bsTree.add(55);
        bsTree.add(24);
        bsTree.add(78);
        bsTree.add(51);
        System.out.println(bsTree.toString() + " Size is " + bsTree.getSize());
    }
}
