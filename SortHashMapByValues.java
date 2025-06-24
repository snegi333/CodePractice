import java.util.*;

public class SortHashMapByValues {

    public static Map<String, Integer> sortByValues(Map<String, Integer> map) {
        // Convert entry set to a list
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort list using a custom comparator (descending by value)
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // LinkedHashMap maintains insertion order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void main(String[] args) {
        // Sample HashMap
        Map<String, Integer> fruitMap = new TreeMap<>();
        fruitMap.put("Apple", 50);
        fruitMap.put("Banana", 20);
        fruitMap.put("Mango", 70);
        fruitMap.put("Grapes", 40);

        System.out.println("HashMap size: " + fruitMap.size());

        System.out.println("Original HashMap:");
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        Map<String, Integer> sortedMap = sortByValues(fruitMap);

        System.out.println("\nSorted HashMap by values:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
