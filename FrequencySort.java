import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Add to max-heap (PriorityQueue with custom comparator)
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        maxHeap.addAll(freqMap.keySet());

        // Step 3: Build the output string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int freq = freqMap.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FrequencySort sorter = new FrequencySort();
        String input = "Aabb";
        String output = sorter.frequencySort(input);
        System.out.println("Output: " + output);
    }
}
