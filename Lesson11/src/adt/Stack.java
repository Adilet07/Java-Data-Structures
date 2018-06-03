package adt;

public interface Stack<T> {

    /**
     *
     * @param x
     */
    public void push(T x);

    /**
     *
     * @return
     * @throws Exception
     */
    public T pop() throws Exception;

    /**
     *
     * @return
     */
    public int getSize();

    /**
     *
     */
    public void clear();

    /**
     *
     * @return
     */
    @Override
    public String toString();

}
