import java.util.Map;
 
public class NestedObjectValueFinder {
 
    public static void main(String[] args) {
        // Example inputs
        Map<String, Object> object1 = Map.of("a", Map.of("b", Map.of("c", "d")));
        String key1 = "a/b/c";
        Map<String, Object> object2 = Map.of("x", Map.of("y", Map.of("z", "a")));
        String key2 = "x/y/z";
 
        // Example usage
        System.out.println(getNestedValue(object1, key1)); // Output: d
        System.out.println(getNestedValue(object2, key2)); // Output: a
    }
 
    public static Object getNestedValue(Map<String, Object> object, String key) {
        String[] keys = key.split("/");
        Map<String, Object> currentObject = object;
 
        for (String k : keys) {
            if (currentObject.containsKey(k)) {
                Object value = currentObject.get(k);
                if (value instanceof Map) {
                    currentObject = (Map<String, Object>) value;
                } else {
                    return value; // Reached the final nested level
                }
            } else {
                return null; // Key not found
            }
        }
 
        return null; // Key is invalid
    }
}