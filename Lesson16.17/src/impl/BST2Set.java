package impl;

import adt.Set;

public class BST2Set<T extends Comparable> implements Set<T> {
    private OnOffTreeNode<T> root;
    private int size;

    @Override
    public void add(T value) {
        if(!active(root,value)){

            if(size==0){

                root = new OnOffTreeNode(value);
                size++;
            }else{

                addHelper(root,value);
            }
        }}

    private void addHelper(OnOffTreeNode<T> node, T value){

        if(contains(value)){
            Switch(root,value);

        } else {

            if(node.getValue().compareTo(value)>0){

                if(node.getLeft()==null){

                    node.setLeft(new OnOffTreeNode(value));
                    node.getLeft().setActive(true);
                    size++;
                } else {

                    addHelper(node.getLeft(),value);
                }
            } else {

                if(node.getRight()==null){

                    node.setRight(new OnOffTreeNode(value));
                    node.getRight().setActive(true);
                    size++;
                } else {

                    addHelper(node.getRight(),value);
                }

            }
        }
    }

    @Override
    public boolean contains(T value) {

        return containsHelper(root, value);
    }

    private boolean containsHelper(OnOffTreeNode<T> checkNode, T value){

        boolean result;
        if(checkNode==null){

            return false;
        }
        if(checkNode.getValue().compareTo(value)>0){

            result = containsHelper(checkNode.getLeft(), value);
        }
        else{

            result = containsHelper(checkNode.getRight(), value);
        }

        if(checkNode.getValue().equals(value)){

            result =true;
        }
        return result;
    }

    private boolean active(OnOffTreeNode<T> checkNode, T value){

        if(checkNode==null){

            return false;
        }else if(checkNode.getValue().compareTo(value)>0){
            // if value is less than root's value
            return active(checkNode.getLeft(), value);
        } else if(checkNode.getValue().compareTo(value)<0){
            // if value is more than root's value
            return active(checkNode.getRight(), value);
        } else {
            //value is already in the set
            return checkNode.isActive();
        }

    }

    @Override
    public boolean remove(T value) {
        OnOffTreeNode<T> checkNode = root;

        if (active(root, value)) {

            while (checkNode != null) {

                if (checkNode.getValue().equals(value)) {

                    checkNode.setActive(false);
                    size--;
                    return true;
                } else {

                    if (checkNode.getValue().compareTo(value) > 0) {

                        checkNode = checkNode.getLeft();
                    } else if (checkNode.getValue().compareTo(value) < 0) {

                        checkNode = checkNode.getRight();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {

        OnOffTreeNode<T> node = root;
        T value = null;

        int size = getSize();

        if (size == 0) {
            throw new Exception("The set is empty");
        }

        T x = removeAnyHelper(root);
        return x;
    }

    public T removeAnyHelper (OnOffTreeNode <T> checkNode) {

        if (checkNode == null) {
            return null;
        }

        if (checkNode.isActive()) {

            size--;
            checkNode.setActive(false);
            return checkNode.getValue();
        }

        T removedNode = removeAnyHelper (checkNode.getLeft());

        if (removedNode != null) {

            return removedNode;
        } else {

            return removeAnyHelper (checkNode.getRight());
        }
    }

    private void Switch(OnOffTreeNode<T> checkNode, T value){
        if(checkNode.getValue().equals(value)){

            checkNode.setActive(true);
            size++;
            return;
        }

        if(checkNode.getValue().compareTo(value)>0){

            Switch(checkNode.getLeft(), value);
        } else {

            Switch(checkNode.getRight(), value);
        }
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
    public String toString() {
        return toStringHelper(root);
    }

    private String toStringHelper(OnOffTreeNode<T> treeStr) {
        if (treeStr == null) {
            return " ";
        } else if(!treeStr.isActive()){
            return " " + toStringHelper(treeStr.getLeft()) + " " + toStringHelper(treeStr.getRight());
        } else {
            return " " + toStringHelper(treeStr.getLeft()) + " " + treeStr.getValue() + " " + toStringHelper(treeStr.getRight());
        }
    }
}
