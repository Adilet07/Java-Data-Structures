package adt;

public interface SortedQueue<T> {

    /**
     *
     * @param value
     */
    public void insert(T value);

    /**
     *
     * @return
     * @throws Exception
     */
    public T dequeue() throws Exception;

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