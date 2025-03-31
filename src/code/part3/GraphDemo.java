package code.part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GraphDemo {

    private static final String[] TOWNS = {
            "Stirling", "Glasgow", "Edinburgh", "Aberdeen", "Dundee", "Inverness", "Perth", "Oban", "Fort William", "Ayr"
    };

    public static void runDemo() {
        // Create adjacency map
        Map<String, List<String>> adjacencyMap = createAdjacencyMap();

        System.out.println("\n=== Graph Representation Demo ===");

        GraphRepresentation.demonstrateRepresentations(TOWNS, adjacencyMap);
    }

    private static Map<String, List<String>> createAdjacencyMap() {
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

}
