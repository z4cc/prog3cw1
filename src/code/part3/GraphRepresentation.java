package code.part3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GraphRepresentation {

    public static void printAdjacencyMap(String[] TOWNS, Map<String, List<String>> adjacencyMap) {
        System.out.println("=== Adjacency Map Representation ===");
        for (String town : TOWNS) {
            System.out.println(town + " -> " + adjacencyMap.get(town));
        }
    }


    public static int[][] createDirectedAdjacencyMatrix(String[] TOWNS, Map<String, List<String>> adjacencyMap) {
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
    

    public static int[][] createUndirectedAdjacencyMatrix(String[] TOWNS, Map<String, List<String>> adjacencyMap) {
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
    public static void printAdjacencyMatrix(String[] TOWNS, Map<String, List<String>> adjacencyMap, int[][] matrix) {
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
    public static void demonstrateRepresentations(String[] TOWNS, Map<String, List<String>> adjacencyMap) {
        System.out.println("\n=== Graph Representation Demo ===\n");
        
        // Create and print adjacency map
        printAdjacencyMap(TOWNS, adjacencyMap);
        System.out.println();
        
        // Create and print undirected adjacency matrix
        int[][] undirectedMatrix = createUndirectedAdjacencyMatrix(TOWNS, adjacencyMap);
        System.out.println("Undirected Graph:");
        printAdjacencyMatrix(TOWNS, adjacencyMap, undirectedMatrix);
        
        // Create and print directed adjacency matrix
        int[][] directedMatrix = createDirectedAdjacencyMatrix(TOWNS, adjacencyMap);
        System.out.println("Directed Graph:");
        printAdjacencyMatrix(TOWNS, adjacencyMap, directedMatrix);
        System.out.println();
    }
}
