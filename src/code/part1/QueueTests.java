package code.part1;

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
        System.out.println("\n=== ArrayBlockingQueue Demo ===");
        
        // Create instance with capacity of 5
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        
        // Add elements
        System.out.println("Adding elements...");
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        
        // Display state
        System.out.println("Queue after adding 3 elements: " + queue);
        
        // Remove an element
        System.out.println("\nRemoving element...");
        String removed = queue.remove();
        
        // Display state
        System.out.println("Removed: " + removed);
        System.out.println("Queue after removal: " + queue);
        
        // Add more elements
        System.out.println("\nAdding more elements...");
        queue.add("Item 4");
        queue.add("Item 5");
        
        // Display state
        System.out.println("Queue after adding 2 more elements: " + queue);
        
        // Try to add when full (this would throw an exception)
        try {
            System.out.println("\nAttempting to add to full queue...");
            queue.add("Item 6"); // This should throw an exception
        } catch (IllegalStateException e) {
            System.out.println("Queue is full: " + e.getMessage());
        }
    }

    private static void testArrayDeque() {
        System.out.println("\n=== ArrayDeque Demo ===");
        
         // Create instance
         ArrayDeque<String> deque = new ArrayDeque<>();
        
         // Add elements at both ends
         System.out.println("Adding elements...");
         deque.addFirst("First A");
         deque.addLast("Last X");
         deque.addFirst("First B");
         deque.addLast("Last Y");
         
         // Display state
         System.out.println("Deque after additions: " + deque);
         
         // Remove elements from both ends
         System.out.println("\nRemoving elements...");
         String removedFirst = deque.removeFirst();
         String removedLast = deque.removeLast();
         
         // Display state
         System.out.println("Removed from front: " + removedFirst);
         System.out.println("Removed from back: " + removedLast);
         System.out.println("Deque after removals: " + deque);
    }

    private static void testLinkedBlockingQueue() {
        System.out.println("\n=== LinkedBlockingQueue Demo ===");
        
        // Create instance
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        
        // Add elements
        System.out.println("Adding elements...");
        queue.add("Item A");
        queue.add("Item B");
        
        // Display state
        System.out.println("Queue after additions: " + queue);
        
        // Remove an element
        System.out.println("\nRemoving element...");
        String removed = queue.remove();
        
        // Display state
        System.out.println("Removed: " + removed);
        System.out.println("Queue after removal: " + queue);
    }

    private static void testLinkedBlockingDeque() {
        System.out.println("\n=== LinkedBlockingDeque Demo ===");
        
        // Create instance
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();
        
        // Add elements at both ends
        System.out.println("Adding elements...");
        deque.addFirst("First 1");
        deque.addLast("Last 1");
        
        // Display state
        System.out.println("Deque after additions: " + deque);
        
        // Remove elements from both ends
        System.out.println("\nRemoving elements...");
        String removedFirst = deque.removeFirst();
        String removedLast = deque.removeLast();
        
        // Display state
        System.out.println("Removed from front: " + removedFirst);
        System.out.println("Removed from back: " + removedLast);
        System.out.println("Deque after removals: " + deque);
    }
}
