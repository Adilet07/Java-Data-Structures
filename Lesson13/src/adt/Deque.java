package adt;

public interface Deque<T> {

    /**
     *
     * @param value
     */
    public void pushToFront(T value);

    /**
     *
     * @param value
     */
    public void pushToBack(T value);

    /**
     *
     * @return
     * @throws Exception
     */
    public T popFromFront() throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    public T popFromBack() throws Exception;

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