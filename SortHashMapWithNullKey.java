import java.util.*;

public class SortHashMapWithNullKey {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("banana", "yellow");
        map.put("apple", "red");
        map.put("cherry", "dark red");
        map.put(null, "no color");

        // Step 1: Extract null key entry
        String nullKeyValue = null;
        if (map.containsKey(null)) {
            nullKeyValue = map.get(null);
            map.remove(null);
        }

        // Step 2: Sort rest of the map by keys
        Map<String, String> sortedMap = new TreeMap<>(map);

        // Step 3: Combine with null key (optionally at the beginning)
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        if (nullKeyValue != null) {
            result.put(null, nullKeyValue); // add null key first
        }
        result.putAll(sortedMap);

        // Print the final map
        for (Map.Entry<String, String> entry : result.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
