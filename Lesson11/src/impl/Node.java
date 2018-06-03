package impl;

public class Node<T> {

    private T value;
    private Node<T> link;

    /**
     *
     * @param val
     */
    public Node(T val) {
        value = val;
        link = null;
    }

    /**
     *
     * @return
     */
    public T getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public Node<T> getLink() {
        return link;
    }

    /**
     *
     * @param link
     */
    public void setLink(Node<T> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
