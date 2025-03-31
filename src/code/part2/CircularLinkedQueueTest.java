package code.part2;

import code.util.DataItem;

public class CircularLinkedQueueTest {
    public static void runDemo() {
        System.out.println("\n=== Custom Circular Linked Queue Demo ===");
        
        // Reset the counter for DataItem
        DataItem.resetCounter();
        
        // Create a new empty circular linked queue
        CircularLinkedQueue<DataItem> queue = new CircularLinkedQueue<>();
        
        // Check initial state
        System.out.println("Initial queue: " + queue);
        System.out.println("Is queue empty? " + queue.isEmpty());
        
        // Add first element
        System.out.println("\nAdding first element...");
        queue.add(new DataItem());
        
        // Display state
        System.out.println("Queue after adding first element: " + queue);
        System.out.println("Queue size: " + queue.size());
        
        // Add more elements
        System.out.println("\nAdding more elements...");
        queue.add(new DataItem());
        queue.add(new DataItem());
        queue.add(new DataItem());
        
        // Display state
        System.out.println("Queue after adding more elements: " + queue);
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element (peek): " + queue.peek());
        
        // Remove elements
        System.out.println("\nRemoving elements...");
        DataItem removed1 = queue.remove();
        
        // Display state
        System.out.println("Removed: " + removed1);
        System.out.println("Queue after removal: " + queue);
        System.out.println("New front element: " + queue.peek());
        
        // Add more after removal to show circular behavior
        System.out.println("\nAdding more elements after removal...");
        queue.add(new DataItem());
        queue.add(new DataItem());
        
        // Display state
        System.out.println("Queue after more additions: " + queue);
        
        // Remove until only one element remains
        System.out.println("\nRemoving elements until one remains...");
        while (queue.size() > 1) {
            System.out.println("Removed: " + queue.remove());
        }
        
        // Display state
        System.out.println("Queue with one element: " + queue);
        
        // Remove last element
        System.out.println("\nRemoving last element...");
        DataItem removedLast = queue.remove();
        
        // Display state
        System.out.println("Removed: " + removedLast);
        System.out.println("Queue after removing all elements: " + queue);
        System.out.println("Is queue empty? " + queue.isEmpty());
        
        // Demonstrate using different data types
        demonstrateGenericBehavior();
    }
    
    private static void demonstrateGenericBehavior() {
        System.out.println("\n=== Demonstrating Generic Behavior ===");
        
        // Create a queue of Integers
        CircularLinkedQueue<Integer> intQueue = new CircularLinkedQueue<>();
        intQueue.add(10);
        intQueue.add(20);
        intQueue.add(30);
        
        System.out.println("Integer Queue: " + intQueue);
        
        // Create a queue of custom objects
        CircularLinkedQueue<Person> personQueue = new CircularLinkedQueue<>();
        personQueue.add(new Person("Alice", 25));
        personQueue.add(new Person("Bob", 30));
        personQueue.add(new Person("Charlie", 22));
        
        System.out.println("Person Queue: " + personQueue);
}
    
    // A simple class to demonstrate storing custom objects
    private static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}
