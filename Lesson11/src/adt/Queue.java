package adt;

public interface Queue<T> {

    /**
     *
     * @param value
     */
    public void enqueue(T value);

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

