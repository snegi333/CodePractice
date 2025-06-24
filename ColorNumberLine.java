import java.util.*;

public class ColorNumberLine {
    public static int[] countConsecutivePairs(int length, int[][] queries) {
        Map<Integer, Integer> line = new HashMap<>(); // Stores only colored positions
        int[] result = new int[queries.length];
        int consecutivePairs = 0;

        for (int i = 0; i < queries.length; i++) {
            int coord = queries[i][0], color = queries[i][1];
            int prevColor = line.getOrDefault(coord, -1);

            if (prevColor == color) {
                result[i] = consecutivePairs;
                continue;
            }

            // Helper function to update consecutive count
            consecutivePairs += updateConsecutiveCount(line, coord - 1, color, prevColor);
            consecutivePairs += updateConsecutiveCount(line, coord + 1, color, prevColor);

            // Update the color
            line.put(coord, color);
            result[i] = consecutivePairs;
        }

        return result;
    }

    private static int updateConsecutiveCount(Map<Integer, Integer> line, int neighbor, int newColor, int oldColor) {
        if (!line.containsKey(neighbor)) return 0;
        int neighborColor = line.get(neighbor);
        if (neighborColor == newColor) return 1;
        if (neighborColor == oldColor) return -1;
        return 0;
    }

    public static void main(String[] args) {
        int length = 7;
        int[][] queries = {
                {1, 2}, {0, 2}, {3, 5}, {3, 2}, {2, 2}, {6, 1}, {1, 3}
        };

        int[] output = countConsecutivePairs(length, queries);
        System.out.println(Arrays.toString(output)); // Expected: [0, 1, 1, 1, 3, 3, 1]
    }
}
