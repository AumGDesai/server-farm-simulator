/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * LinkedList.java
 * 
 * Creates a linked list class
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedList<T> implements Queue<T> {
    private Node<T> head;  // first node in the list
    private int size; // number of elements in the list

    // constructor that creates an empty list
    public LinkedList() {
        head = null;
        size = 0;
    }

    // inserts the item at the beginning of the list
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    // inserts the item at the specified position in the list
    public void add(int index, T item) {
        if (index < 0) {
            System.out.println("Index cannot be negative: " + index);
            return;
        }
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    System.out.println("Index out of bounds: " + index);
                    return;
                }
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    // Empties the list.
    // Resets the head pointer to null, effectively removing all nodes from the list.
    public void clear() {
        head = null;
        size = 0;
    }

    // returns true if o is present in this list, otherwise returns false
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // returns true if o is a LinkedList that also contains the same items in the same order.
    public boolean equals(Object o) {
        // Check if o is itself a LinkedList
        if (!(o instanceof LinkedList)) {
            return false;
        }
        // If we have reached this line, o must be a LinkedList
        LinkedList<?> oAsALinkedList = (LinkedList<?>) o;

        // Iterate through both lists, comparing each node's data
        Node<T> current = head;
        Node<?> otherCurrent = oAsALinkedList.head;
        while (current != null && otherCurrent != null) {
            if (!current.getData().equals(otherCurrent.getData())) {
                return false;
            }
            current = current.getNext();
            otherCurrent = otherCurrent.getNext();
        }

        // If one list still has nodes remaining, but the other does not, they are not equal
        if (current != null || otherCurrent != null) {
            return false;
        }

        // If we have reached this line, all nodes in both lists were equal
        return true;
    }

    public T get(int index) {
        if (index < 0) {
            System.out.println("Index cannot be negative: " + index);
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                System.out.println("Index out of bounds: " + index);
                return null;
            }
            current = current.getNext();
        }
        if (current == null) {
            System.out.println("Index out of bounds: " + index);
            return null;
        }
        return current.getData();
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public T remove() {
        if (head == null) {
            System.out.println("List is empty, cannot remove item.");
            return null;
        }
        T data = head.getData();
        head = head.getNext();
        return data;
    }
    
    public T remove(int index) {
        if (index < 0) {
            System.out.println("Index cannot be negative: " + index);
            return null;
        }
        if (index == 0) {
            return remove();
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                System.out.println("Index out of bounds: " + index);
                return null;
            }
            current = current.getNext();
        }
        if (current == null || current.getNext() == null) {
            System.out.println("Index out of bounds: " + index);
            return null;
        }
        T data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        return data;
    }
    
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    private class LLIterator implements Iterator<T> {
        private Node<T> nextNode;

        LLIterator(Node<T> head) {
            this.nextNode = head;
        }

        public boolean hasNext() {
            return this.nextNode != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T data = (T) this.nextNode.data;
            this.nextNode = this.nextNode.next;
            return data;
        }

        public void remove() {
            // Optional implementation
        }
    }

    public Iterator<T> iterator() {
        return new LLIterator(this.head);
    }
    

    // private nested class that represents a single node in the linked list
    private static class Node<T> {
        private Node<T> next;  // pointer to the next node in the list
        private T data;     // data stored in the node

        // constructor that creates a new node with the given data and null next pointer
        public Node(T item) {
            this.data = item;
            this.next = null;
        }

        // returns the data stored in this node
        public T getData() {
            return data;
        }

        // sets the next node in the list
        public void setNext(Node<T> n) {
            next = n;
        }

        // returns the next node in the list
        public Node<T> getNext() {
            return next;
        }
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<T>();
        Node<T> currentNode = head;
        while (currentNode != null) {
            arrayList.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return arrayList;
    } 
    
    // This method returns the data stored in the first node of the linked list,
    // without removing it from the list. If the list is empty, it returns null.

    public T peek() {
        if (head == null) {
            System.out.println("List is empty, cannot peek."); // print message indicating that the list is empty
            return null;
        }
        return head.getData(); // return the data stored in the first node of the list
    }
    
    // This method returns and removes the data stored in the first node of the linked list.
    // If the list is empty, it returns null.
    public T poll(){
        if (head == null) {
            System.out.println("List is empty, cannot poll."); // print message indicating that the list is empty
            return null;
        }
        T data = head.getData(); // store the data stored in the first node of the list in a variable
        head = head.getNext(); // update the head of the list to the next node
        return data; // return the stored data
    }
    
    // This method adds an item to the end of the linked list.
    public void offer(T item) {
        if (head == null) { // if the list is empty
            head = new Node<T>(item); // create a new node with the specified data and set it as the head of the list
            return;
        }
        Node<T> current = head; // start at the head of the list
        while (current.getNext() != null) { // loop until we reach the end of the list
            current = current.getNext(); // move to the next node
        }
        current.setNext(new Node<T>(item)); // create a new node with the specified data and set it as the next node after the current node
    }

    @Override
    public void add(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    

}





