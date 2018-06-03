package impl;

import adt.Set;

public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;


    public BSTSet() {
        root = null;
        size = 0;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void add(T value) {

        if (!contains(value)){

            if (root==null){

                root = new TreeNode(value);
                size++;

            } else {

                addHelper(root,value);

            }

        }
    }

    private TreeNode<T> addHelper (TreeNode<T> checkNode , T value){

        TreeNode<T> inputVal = new TreeNode(value);

        if (checkNode.getValue().compareTo(inputVal.getValue())>0) {       // if value is less than root's value

            if (checkNode.getLeft()==null){

                checkNode.setLeft(inputVal);
                size++;
                return checkNode;

            } else {
                addHelper(checkNode.getLeft(),value);
            }


        } else if (checkNode.getValue().compareTo(inputVal.getValue())<0){     // if value is more than root's value

            if (checkNode.getRight()==null){

                checkNode.setRight(inputVal);
                size++;
                return checkNode;

            } else {
                addHelper(checkNode.getRight(),value);
            }
        }
        return checkNode;
    }



    @Override
    public boolean contains(T value) {

        return containsHelper(root,value);
    }

    private boolean containsHelper(TreeNode<T> checkNode, T value){

        if (checkNode==null){

            return false;
        } else if (checkNode.getValue().compareTo(value)>0){
            // if value is less than root's value
            return containsHelper(checkNode.getLeft(), value);

        } else if (checkNode.getValue().compareTo(value)<0){
            // if value is more than root's value
            return containsHelper(checkNode.getRight(), value);

        } else {
            //value is already in the set
            return true;
        }

    }

    @Override
    public boolean remove(T value) {

        if(!contains(value)) {

            return false;

        } else if(value.compareTo(root.getValue()) == 0) {

            if(root.getLeft() == null && root.getRight() == null) {

                root = null;

            } else if(root.getLeft() == null) {

                root = root.getRight();

            } else if(root.getRight() == null){

                root = root.getLeft();

            } else {

                TreeNode<T> current2 = root.getRight();
                TreeNode<T> parent2 = root;

                while(current2.getLeft() != null){
                    parent2 = current2;
                    current2 = current2.getLeft();
                }

                root.setValue(current2.getValue());

                if(current2.getRight() != null){

                    if(root == parent2){

                        parent2.setRight(current2.getRight());

                    } else {
                        parent2.setLeft(current2.getRight());
                    }
                } else {

                    if(root == parent2) {

                        parent2.setRight(null);
                    } else {

                        parent2.setLeft(null);
                    }
                }
            }

            size--;

            return true;

        } else {

            TreeNode<T> parent1 = root;
            TreeNode<T> current1 = root;

            while(current1.getValue().compareTo(value) != 0){

                if(value.compareTo(current1.getValue()) < 0){

                    parent1 = current1;
                    current1 = current1.getLeft();

                } else {

                    parent1 = current1;
                    current1 = current1.getRight();

                }
            }

            if(current1.getLeft() == null && current1.getRight() == null){

                parent1.setLeft(null);
                parent1.setRight(null);

            } else if(current1.getLeft() == null) {

                if(parent1.getValue().compareTo(current1.getValue()) < 0){

                    parent1.setRight(current1.getRight());

                } else {

                    parent1.setLeft(current1.getRight());

                }

            } else if(current1.getRight() == null){

                if(parent1.getValue().compareTo(current1.getValue()) < 0){

                    parent1.setRight(current1.getLeft());

                } else {

                    parent1.setLeft(current1.getLeft());
                }

            } else {

                TreeNode<T> current2 = current1.getRight();
                TreeNode<T> parent2 = current1;

                while(current2.getLeft() != null){

                    parent2 = current2;
                    current2 = current2.getLeft();

                }

                current1.setValue(current2.getValue());

                if(current2.getRight() != null){

                    if(current1 == parent2) {
                        parent2.setRight(current2.getRight());
                    }
                    else {
                        parent2.setLeft(current2.getRight());
                    }

                } else {

                    if(current1 == parent2) {
                        parent2.setRight(null);
                    } else {
                        parent2.setLeft(null);
                    }
                }
            }

            size--;
            return true;
        }
    }

    @Override
    public T removeAny() throws Exception {

        if(root == null){

            throw new Exception("Empty!");
        } else {

            T temp = root.getValue();
            remove(root.getValue());

            return temp;
        }
    }

    public void setSize(int size) {

        this.size = size;
    }

    @Override
    public int getSize() {

        return size;
    }

    @Override
    public void clear() {

        root = null;
        size = 0;
    }

    public String toString(){

        return toStringHelper(root);
    }

    public String toStringHelper(TreeNode treeStr){

        if (treeStr == null) {
            return " ";
        }

        return toStringHelper(treeStr.getLeft()) + " " + treeStr.getValue() + " " + toStringHelper(treeStr.getRight());

    }


}
