
package impl;
import adt.Set;

public class BSTSet<T extends Comparable> implements Set<T>{

    private TreeNode<T> root;
    private int size;

    public void BSTSet(){
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            if(root != null){
                addChecker(root, value);
                size++;
            } else{
                root = new TreeNode(value);
                size++;
            }
        }
    }

    private TreeNode<T> addChecker(TreeNode<T> node, T value){
        TreeNode<T> temp = new TreeNode(value);
        if(node != null){
            if(value.compareTo(node.getValue()) < 0){
                if(node.getLeft() != null)
                    return addChecker(node.getLeft(), value);
                else{
                    node.setLeft(temp);
                    return temp;
                }
            } else{
                if(node.getRight() != null)
                    return addChecker(node.getRight(), value);
                else{
                    node.setRight(temp);
                    return temp;
                }
            }
        }
        return node;
    }

    @Override
    public boolean contains(T value) {
        return conChecker(root, value);
    }

    private boolean conChecker(TreeNode<T> node, T value){
        if (node != null){
            if(value.compareTo(node.getValue()) == 0){
                return true;
            }  else {
                if (value.compareTo(node.getValue()) < 0)
                    return conChecker(node.getLeft(), value);
                else {
                    return conChecker(node.getRight(), value);
                }
            }
        } else {
            return false;
        }
    }


    @Override
    public boolean remove(T value) {
        if (!contains(value)) {
            return false;
        } else if(value.compareTo(root.getValue()) == 0){
            if(root.getLeft() == null && root.getRight() == null){
                root = null;
            } else if(root.getLeft() == null){
                root = root.getRight();
            } else if(root.getRight() == null){
                root = root.getLeft();
            } else{
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
                    }else
                        parent2.setLeft(current2.getRight());
                } else{
                    if(root == parent2)
                        parent2.setRight(null);
                    else
                        parent2.setLeft(null);
                }
            }
            size--;
            return true;
        } else{
            TreeNode<T> parent = root;
            TreeNode<T> current = root;
            while(current.getValue().compareTo(value) != 0){
                if(value.compareTo(current.getValue()) < 0){
                    parent = current;
                    current = current.getLeft();
                } else{
                    parent = current;
                    current = current.getRight();
                }
            }
            if(current.getLeft() == null && current.getRight() == null){
                parent.setLeft(null);
                parent.setRight(null);
            } else if(current.getLeft() == null){
                if(parent.getValue().compareTo(current.getValue()) < 0){
                    parent.setRight(current.getRight());
                } else{
                    parent.setLeft(current.getRight());
                }
            } else if(current.getRight() == null){
                if(parent.getValue().compareTo(current.getValue()) < 0){
                    parent.setRight(current.getLeft());
                } else{
                    parent.setLeft(current.getLeft());
                }
            } else{
                TreeNode<T> current2 = current.getRight();
                TreeNode<T> parent2 = current;
                while(current2.getLeft() != null){
                    parent2 = current2;
                    current2 = current2.getLeft();
                }
                current.setValue(current2.getValue());
                if(current2.getRight() != null){
                    if(current == parent2)
                        parent2.setRight(current2.getRight());
                    else
                        parent2.setLeft(current2.getRight());
                } else{
                    if(current == parent2)
                        parent2.setRight(null);
                    else
                        parent2.setLeft(null);
                }
            }
            size--;
            return true;
        }
    }

    @Override
    public T removeAny() throws Exception {
        if(root != null){
            T t = root.getValue();
            remove(root.getValue());
            return t;
        } else{
            throw new Exception("Nothing to remove");
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

    public String toString(){
        return toStringHelper(root);
    }

    private String toStringHelper(TreeNode<T> node){
        if(node == null)
            return " ";
        return toStringHelper(node.getLeft()) +
                node.getValue() +
                toStringHelper(node.getRight());
    }
}
