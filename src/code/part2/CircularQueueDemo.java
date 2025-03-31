package code.part2;

import code.util.DataItem;
import java.util.ArrayDeque;

public class CircularQueueDemo {
    public static void demonstrateArrayDeque() {
        System.out.println("\n=== ArrayDeque Circular Queue Demo ===");
        
        // Reset the counter for DataItem
        DataItem.resetCounter();
        
        // Create an ArrayDeque with initial capacity of 8
        ArrayDeque<DataItem> circularQueue = new ArrayDeque<>(8);
        
        // Add elements to fill the queue partially
        System.out.println("Adding initial elements...");
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        
        // Display state
        System.out.println("Queue after adding 5 elements: " + circularQueue);
        
        // Remove some elements to create "gaps" at the beginning
        System.out.println("\nRemoving elements from the front...");
        DataItem removed1 = circularQueue.remove();
        DataItem removed2 = circularQueue.remove();
        
        // Display state
        System.out.println("Removed: " + removed1 + ", " + removed2);
        System.out.println("Queue after removals: " + circularQueue);
        
        // Add more elements to demonstrate wraparound behavior
        System.out.println("\nAdding more elements to demonstrate circular behavior...");
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        circularQueue.add(new DataItem());
        
        // Display state
        System.out.println("Queue after wraparound: " + circularQueue);
        
        // Remove elements until we're back to the beginning of the array
        System.out.println("\nRemoving elements to show complete rotation...");
        for (int i = 0; i < 7; i++) {
            System.out.println("Removed: " + circularQueue.remove());
        }
        
        // Display state
        System.out.println("Queue after complete rotation: " + circularQueue);
        
        // Demonstrate array expansion by adding many elements
        System.out.println("\nAdding elements to force array expansion...");
        for (int i = 12; i <= 20; i++) {
            circularQueue.add(new DataItem());
        }
        
        // Display state
        System.out.println("Queue after adding many elements: " + circularQueue);
    }
}
