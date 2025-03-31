package code.util;

public class DataItem {
    // Static counter to generate sequential IDs
    private static int counter = 0;
    
    // Instance variables
    private final int id;
    private final String name;
    private final String value;
    
    /**
     * Creates a new DataItem with an auto-incremented ID and specified value.
     * 
     * @param value The value to store in this item
     */
    public DataItem(String value) {
        this.id = ++counter;
        this.name = "Item " + id;
        this.value = value;
    }
    
    /**
     * Creates a new DataItem with an auto-incremented ID.
     */
    public DataItem() {
        this("Value " + (counter + 1));
    }
    
    /**
     * Reset the counter to zero.
     * This might be useful between different demonstration runs.
     */
    public static void resetCounter() {
        counter = 0;
    }
    
    /**
     * Get the ID of this item.
     * 
     * @return The auto-assigned ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Get the name of this item.
     * 
     * @return The name in format "Item X"
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the value of this item.
     * 
     * @return The stored value
     */
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return name + " (" + value + ")";
    }
}
