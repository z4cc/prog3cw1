package code.part1;

import code.util.DataItem;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTests {
    public static void runDemo() {
        testArrayBlockingQueue();
        testArrayDeque();
        testLinkedBlockingQueue();
        testLinkedBlockingDeque();
    }

    private static void testArrayBlockingQueue() {
        DataItem.resetCounter();
        System.out.println("\n=== ArrayBlockingQueue Demo ===");
        
        // Create instance with capacity of 5
        ArrayBlockingQueue<DataItem> queue = new ArrayBlockingQueue<>(5);
        
        // Add elements
        System.out.println("Adding elements...");
        queue.add(new DataItem()); // Empty constructor for "Item 1"
        queue.add(new DataItem()); // Empty constructor for "Item 2"
        queue.add(new DataItem()); // Empty constructor for "Item 3"
        
        // Display state
        System.out.println("Queue after adding 3 elements: " + queue);
        
        // Remove an element
        System.out.println("\nRemoving element...");
        DataItem removed = queue.remove();
        
        // Display state
        System.out.println("Removed: " + removed);
        System.out.println("Queue after removal: " + queue);
        
        // Add more elements
        System.out.println("\nAdding more elements...");
        queue.add(new DataItem()); // Empty constructor for "Item 4"
        queue.add(new DataItem()); // Empty constructor for "Item 5"
        queue.add(new DataItem()); // Empty constructor for "Item 6"
        
        // Display state
        System.out.println("Queue after adding 3 more elements: " + queue);
        
        // Try to add when full (this would throw an exception)
        try {
            System.out.println("\nAttempting to add to full queue...");
            queue.add(new DataItem()); // Empty constructor for "Item 7"
        } catch (IllegalStateException e) {
            System.out.println("Queue is full: " + e.getMessage());
        }
    }

    private static void testArrayDeque() {
        DataItem.resetCounter();
        System.out.println("\n=== ArrayDeque Demo ===");
        
        // Create instance
        ArrayDeque<DataItem> deque = new ArrayDeque<>();
        
        // Add elements at both ends
        System.out.println("Adding elements...");
        deque.addFirst(new DataItem("First A"));
        deque.addLast(new DataItem("Last X"));
        deque.addFirst(new DataItem("First B"));
        deque.addLast(new DataItem("Last Y"));
        
        // Display state
        System.out.println("Deque after additions: " + deque);
        
        // Remove elements from both ends
        System.out.println("\nRemoving elements...");
        DataItem removedFirst = deque.removeFirst();
        DataItem removedLast = deque.removeLast();
        
        // Display state
        System.out.println("Removed from front: " + removedFirst);
        System.out.println("Removed from back: " + removedLast);
        System.out.println("Deque after removals: " + deque);
    }

    private static void testLinkedBlockingQueue() {
        System.out.println("\n=== LinkedBlockingQueue Demo ===");
        
        // Create instance
        LinkedBlockingQueue<DataItem> queue = new LinkedBlockingQueue<>();
        
        // Add elements
        System.out.println("Adding elements...");
        queue.add(new DataItem()); // Empty constructor for "Item A"
        queue.add(new DataItem()); // Empty constructor for "Item B"
        
        // Display state
        System.out.println("Queue after additions: " + queue);
        
        // Remove an element
        System.out.println("\nRemoving element...");
        DataItem removed = queue.remove();
        
        // Display state
        System.out.println("Removed: " + removed);
        System.out.println("Queue after removal: " + queue);
    }

    private static void testLinkedBlockingDeque() {
        DataItem.resetCounter();
        System.out.println("\n=== LinkedBlockingDeque Demo ===");
        
        // Create instance
        LinkedBlockingDeque<DataItem> deque = new LinkedBlockingDeque<>();
        
        // Add elements at both ends
        System.out.println("Adding elements...");
        deque.addFirst(new DataItem("First 1"));
        deque.addLast(new DataItem("Last 1"));
        
        // Display state
        System.out.println("Deque after additions: " + deque);
        
        // Remove elements from both ends
        System.out.println("\nRemoving elements...");
        DataItem removedFirst = deque.removeFirst();
        DataItem removedLast = deque.removeLast();
        
        // Display state
        System.out.println("Removed from front: " + removedFirst);
        System.out.println("Removed from back: " + removedLast);
        System.out.println("Deque after removals: " + deque);
    }
}
