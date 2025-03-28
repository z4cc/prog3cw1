package code.part2;

import java.util.ArrayDeque;

public class CircularQueueDemo {
    public static void demonstrateArrayDeque() {
        System.out.println("\n=== ArrayDeque Circular Queue Demo ===");
        
        // Create an ArrayDeque with initial capacity of 8 (default)
        ArrayDeque<String> circularQueue = new ArrayDeque<>();
        
        // Add elements to fill the queue partially
        System.out.println("Adding initial elements...");
        circularQueue.add("Item 1");
        circularQueue.add("Item 2");
        circularQueue.add("Item 3");
        circularQueue.add("Item 4");
        circularQueue.add("Item 5");
        
        // Display state (Visualization Point 1)
        // At this point, the queue has 5 elements, with head at position 0
        System.out.println("Queue after adding 5 elements: " + circularQueue);
        
        // Remove some elements to create "gaps" at the beginning
        System.out.println("\nRemoving elements from the front...");
        String removed1 = circularQueue.remove();
        String removed2 = circularQueue.remove();
        
        // Display state (Visualization Point 2)
        // Now the queue has 3 elements, with head at position 2
        System.out.println("Removed: " + removed1 + ", " + removed2);
        System.out.println("Queue after removals: " + circularQueue);
        
        // Add more elements to demonstrate wraparound behavior
        // This will add elements to the empty spaces at the beginning
        System.out.println("\nAdding more elements to demonstrate circular behavior...");
        circularQueue.add("Item 6");
        circularQueue.add("Item 7");
        circularQueue.add("Item 8");
        circularQueue.add("Item 9");
        circularQueue.add("Item 10");
        circularQueue.add("Item 11");
        
        // Display state (Visualization Point 3)
        // The queue now has wrapped around, with some elements at the end and some at the beginning
        System.out.println("Queue after wraparound: " + circularQueue);
        
        // Remove elements until we're back to the beginning of the array
        System.out.println("\nRemoving elements to show complete rotation...");
        for (int i = 0; i < 6; i++) {
            System.out.println("Removed: " + circularQueue.remove());
            // After each removal, you could set a breakpoint to visualize (optional)
        }
        
        // Display state (Visualization Point 4)
        // The queue now has wrapped completely, with remaining elements at the beginning
        System.out.println("Queue after complete rotation: " + circularQueue);
        
        // Demonstrate array expansion by adding many elements
        System.out.println("\nAdding elements to force array expansion...");
        for (int i = 12; i <= 20; i++) {
            circularQueue.add("Item " + i);
        }
        
        // Display state (Visualization Point 5)
        // The internal array has been resized to accommodate more elements
        System.out.println("Queue after adding many elements: " + circularQueue);
    }

}
