package code.part2;

import java.util.NoSuchElementException;

public class CircularLinkedQueue <E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
            this.next = null;
        }
        
        @Override
        public String toString() {
            return data.toString();
        }
    }
    
    private Node<E> tail;
    private int size;
    
    /**
     * Constructs an empty circular linked queue.
     */
    public CircularLinkedQueue() {
        tail = null;
        size = 0;
    }
    
    /**
     * Adds an element to the end of the queue.
     * 
     * @param element the element to add
     * @return true (as specified by the Collection interface)
     */
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);
        
        if (isEmpty()) {
            // If queue is empty, the new node points to itself
            newNode.next = newNode;
            tail = newNode;
        } else {
            // Insert the new node after tail and update tail
            newNode.next = tail.next; // Connect new node to front
            tail.next = newNode;      // Connect tail to new node
            tail = newNode;           // Update tail to point to new node
        }
        
        size++;
        return true;
    }
    
    /**
     * Removes and returns the element at the front of the queue.
     * 
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        Node<E> front = tail.next;
        E data = front.data;
        
        if (front == tail) {
            // If there's only one node in the queue
            tail = null;
        } else {
            // Remove the front node by updating tail's next reference
            tail.next = front.next;
        }
        
        size--;
        return data;
    }
    
    /**
     * Returns the element at the front of the queue without removing it.
     * 
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return tail.next.data;
    }
    
    /**
     * Returns the number of elements in the queue.
     * 
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return tail == null;
    }
    
    /**
     * Returns a string representation of the queue.
     * 
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = tail.next; // Start at front
        
        // Loop through the circular queue once
        do {
            sb.append(current.data);
            current = current.next;
            if (current != tail.next) {
                sb.append(", ");
            }
        } while (current != tail.next);
        
        sb.append("]");
        return sb.toString();
    }
}

