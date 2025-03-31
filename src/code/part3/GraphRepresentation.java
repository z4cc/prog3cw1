package code.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphRepresentation {
    private static final String[] TOWNS = {
            "Stirling", "Glasgow", "Edinburgh", "Aberdeen", "Dundee", "Inverness", "Perth", "Oban", "Fort William", "Ayr"
    };

    public static Map<String, List<String>> createAdjacencyMap() {
        Map<String, List<String>> adjacencyMap = new HashMap<>();
        
        // Initialize empty lists for each town
        for (String town : TOWNS) {
            adjacencyMap.put(town, new ArrayList<>());
        }
        
        addConnection(adjacencyMap, "Stirling", "Fort William");
        addConnection(adjacencyMap, "Stirling", "Perth");

        addConnection(adjacencyMap, "Fort William", "Ayr");

        addConnection(adjacencyMap, "Glasgow", "Stirling");
        addConnection(adjacencyMap, "Glasgow", "Inverness");
        addConnection(adjacencyMap, "Glasgow", "Dundee");

        addConnection(adjacencyMap, "Edinburgh", "Glasgow");
        addConnection(adjacencyMap, "Edinburgh", "Aberdeen");

        addConnection(adjacencyMap, "Aberdeen", "Inverness");
        addConnection(adjacencyMap, "Aberdeen", "Perth");

        addConnection(adjacencyMap, "Dundee", "Perth");

        addConnection(adjacencyMap, "Inverness", "Oban");
        addConnection(adjacencyMap, "Inverness", "Fort William");

        addConnection(adjacencyMap, "Perth", "Oban");

        addConnection(adjacencyMap, "Oban", "Ayr");

        return adjacencyMap;
    }
    
    private static void addConnection(Map<String, List<String>> adjacencyMap, String from, String to) {
        // Check if towns exist in the map before adding
        if (adjacencyMap.containsKey(from) && adjacencyMap.containsKey(to)) {
            adjacencyMap.get(from).add(to);
        } else {
            System.err.println("Warning: Tried to add connection between non-existent towns: " 
                                + from + " -> " + to);
        }
    }
    
    /**
     * Prints the adjacency map representation of the graph.
     */
    public static void printAdjacencyMap(Map<String, List<String>> adjacencyMap) {
        System.out.println("=== Adjacency Map Representation ===");
        for (String town : TOWNS) {
            System.out.println(town + " -> " + adjacencyMap.get(town));
        }
    }

    /**
     * Creates an adjacency matrix for the directed graph.
     * A cell [i][j] is 1 if there's a directed edge from town i to town j.
     * 
     * This method uses the adjacency map to build the matrix.
     */
    public static int[][] createDirectedAdjacencyMatrix() {
        Map<String, List<String>> adjacencyMap = createAdjacencyMap();
        int n = TOWNS.length;
        int[][] matrix = new int[n][n];
        
        // Populate matrix from adjacency map
        for (int i = 0; i < n; i++) {
            String from = TOWNS[i];
            List<String> connections = adjacencyMap.get(from);
            
            for (String to : connections) {
                int j = Arrays.asList(TOWNS).indexOf(to);
                if (j >= 0) {
                    matrix[i][j] = 1;
                }
            }
        }
        
        return matrix;
    }
    
    /**
     * Creates an adjacency matrix for the undirected version of the graph.
     * This treats all connections as bidirectional.
     */
    public static int[][] createUndirectedAdjacencyMatrix() {
        Map<String, List<String>> adjacencyMap = createAdjacencyMap();
        int n = TOWNS.length;
        int[][] matrix = new int[n][n];
        
        // First pass: Add all directed edges
        for (int i = 0; i < n; i++) {
            String from = TOWNS[i];
            List<String> connections = adjacencyMap.get(from);
            
            for (String to : connections) {
                int j = Arrays.asList(TOWNS).indexOf(to);
                if (j >= 0) {
                    matrix[i][j] = 1;
                    // For undirected graph, make symmetric
                    matrix[j][i] = 1;
                }
            }
        }
        
        return matrix;
    }
    
    /**
     * Prints an adjacency matrix with town labels.
     */
    public static void printAdjacencyMatrix(int[][] matrix) {
        System.out.println("=== Adjacency Matrix ===");
        
        // Print header row with abbreviated town names
        System.out.print("    ");
        for (String town : TOWNS) {
            System.out.print(town.substring(0, Math.min(3, town.length())) + " ");
        }
        System.out.println();
        
        // Print each row with town label
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(TOWNS[i].substring(0, Math.min(3, TOWNS[i].length())) + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    /**
     * Demonstrates all graph representations.
     */
    public static void demonstrateRepresentations() {
        System.out.println("\n=== Graph Representation Demo ===\n");
        
        // Create and print adjacency map
        Map<String, List<String>> adjacencyMap = createAdjacencyMap();
        printAdjacencyMap(adjacencyMap);
        System.out.println();
        
        // Create and print undirected adjacency matrix
        int[][] undirectedMatrix = createUndirectedAdjacencyMatrix();
        System.out.println("Undirected Graph:");
        printAdjacencyMatrix(undirectedMatrix);
        
        // Create and print directed adjacency matrix
        int[][] directedMatrix = createDirectedAdjacencyMatrix();
        System.out.println("Directed Graph:");
        printAdjacencyMatrix(directedMatrix);
        System.out.println();
    }
}
