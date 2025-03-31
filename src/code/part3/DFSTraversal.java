package code.part3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFSTraversal {
     public static void depthFirstSearch(Map<String, List<String>> adjacencyMap, String startTown) {
        // Set to keep track of visited towns
        Set<String> visited = new HashSet<>();
        
        // Stack to manage the DFS traversal
        Stack<String> stack = new Stack<>();
        
        // List to store the traversal path for display
        List<String> traversalPath = new ArrayList<>();
        
        // Start at the specified town
        stack.push(startTown);
        
        System.out.println("=== DFS Traversal from " + startTown + " ===");
        System.out.println("Step-by-step algorithm execution:");
        
        int step = 1;
        
        while (!stack.isEmpty()) {
            // Pop the next town to visit
            String currentTown = stack.pop();
            
            // Display the current state for visualization
            System.out.println("\nStep " + step++ + ":");
            System.out.println("Current town: " + currentTown);
            System.out.println("Stack: " + stack);
            System.out.println("Visited: " + visited);
            
            // If already visited, skip it
            if (visited.contains(currentTown)) {
                System.out.println(currentTown + " already visited, skipping.");
                continue;
            }
            
            // Mark as visited and add to traversal path
            visited.add(currentTown);
            traversalPath.add(currentTown);
            
            System.out.println("Marking " + currentTown + " as visited.");
            System.out.println("Current traversal path: " + traversalPath);
            
            // Get all adjacent towns
            List<String> neighbors = adjacencyMap.get(currentTown);
            System.out.println("Neighbors of " + currentTown + ": " + neighbors);
            
            // Push neighbors onto stack in reverse order to maintain original order in traversal
            // when popped off the stack
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                String neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) {
                    System.out.println("Pushing " + neighbor + " onto stack.");
                    stack.push(neighbor);
                } else {
                    System.out.println(neighbor + " already visited, not pushing onto stack.");
                }
            }
            
            // Display updated stack
            System.out.println("Updated stack: " + stack);
        }
        
        System.out.println("\nFinal DFS traversal path: " + traversalPath);
    }
    
    /**
     * Recursive implementation of DFS traversal.
     * This is an alternative to the iterative approach shown above.
     */
    public static void recursiveDepthFirstSearch(Map<String, List<String>> adjacencyMap, String currentTown,
                                               Set<String> visited, List<String> traversalPath) {
        // Mark the current town as visited
        visited.add(currentTown);
        traversalPath.add(currentTown);
        
        System.out.println("Visiting: " + currentTown);
        System.out.println("Current path: " + traversalPath);
        
        // Visit all adjacent towns
        for (String neighbor : adjacencyMap.get(currentTown)) {
            if (!visited.contains(neighbor)) {
                System.out.println("From " + currentTown + ", recursively visiting " + neighbor);
                recursiveDepthFirstSearch(adjacencyMap, neighbor, visited, traversalPath);
            } else {
                System.out.println(neighbor + " already visited, skipping.");
            }
        }
    }
    
    /**
     * Demo method to run both DFS implementations.
     */
    public static void runDemo(Map<String, List<String>> adjacencyMap) {
        System.out.println("\n=== Depth-First Search Traversal Demo ===\n");
        
        // Run the iterative DFS starting from Inverness
        depthFirstSearch(adjacencyMap, "Inverness");
        
        System.out.println("\n=== Recursive DFS Traversal from Inverness ===\n");
        Set<String> visited = new HashSet<>();
        List<String> traversalPath = new ArrayList<>();
        recursiveDepthFirstSearch(adjacencyMap, "Inverness", visited, traversalPath);
        
        System.out.println("\nFinal recursive DFS traversal path: " + traversalPath);
    }

}
