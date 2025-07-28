/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * Queue.java
 * 
 * Creates a linked list class
 */


public interface Queue<T> {

    /**
     * Adds the item to the back of the queue.
     * @param item the item to add.
     */
    public void offer(T item);

    /**
     * Returns the number of items in the queue.
     * @return the number of items in the queue.
     */
    public int size();

    /**
     * Returns the item at the front of the queue.
     * @return the item at the front of the queue.
     */
    public T peek();

    /**
     * Returns and removes the item at the front of the queue.
     * @return the item at the front of the queue.
     */
    public T poll();

    public void add(int i);
}