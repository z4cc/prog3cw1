package code.part2;

public class CircularLinkedQueueTest {
    public static void runDemo() {
        System.out.println("\n=== Custom Circular Linked Queue Demo ===");
        
        // Create a new empty circular linked queue
        CircularLinkedQueue<String> queue = new CircularLinkedQueue<>();
        
        // Check initial state
        System.out.println("Initial queue: " + queue);
        System.out.println("Is queue empty? " + queue.isEmpty());
        
        // Add first element
        System.out.println("\nAdding first element...");
        queue.add("Item 1");
        
        // Display state (Visualization Point 1)
        // This shows a queue with a single node that points to itself
        System.out.println("Queue after adding first element: " + queue);
        System.out.println("Queue size: " + queue.size());
        
        // Add more elements
        System.out.println("\nAdding more elements...");
        queue.add("Item 2");
        queue.add("Item 3");
        queue.add("Item 4");
        
        // Display state (Visualization Point 2)
        // This shows a queue with multiple elements forming a circle
        System.out.println("Queue after adding more elements: " + queue);
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element (peek): " + queue.peek());
        
        // Remove elements
        System.out.println("\nRemoving elements...");
        String removed1 = queue.remove();
        
        // Display state (Visualization Point 3)
        // This shows how the queue looks after removing the front element
        System.out.println("Removed: " + removed1);
        System.out.println("Queue after removal: " + queue);
        System.out.println("New front element: " + queue.peek());
        
        // Add more after removal to show circular behavior
        System.out.println("\nAdding more elements after removal...");
        queue.add("Item 5");
        queue.add("Item 6");
        
        // Display state (Visualization Point 4)
        // This shows how elements are added after some removals
        System.out.println("Queue after more additions: " + queue);
        
        // Remove until only one element remains
        System.out.println("\nRemoving elements until one remains...");
        while (queue.size() > 1) {
            System.out.println("Removed: " + queue.remove());
            // After each removal, you could set a breakpoint to visualize (optional)
        }
        
        // Display state (Visualization Point 5)
        // This shows a queue with only one element
        System.out.println("Queue with one element: " + queue);
        
        // Remove last element
        System.out.println("\nRemoving last element...");
        String removedLast = queue.remove();
        
        // Display state (Visualization Point 6)
        // This shows an empty queue after all elements have been removed
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
