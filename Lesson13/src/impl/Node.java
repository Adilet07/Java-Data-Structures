package impl;

public class Node<T> {

    private T value;
    private Node<T> link;

    public Node(T val) {

        value = val;
        link = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T val) {
        value = val;
    }

    public Node<T> getLink() {
        return link;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
