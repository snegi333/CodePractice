import java.util.*;

public class NumberLineColoring {
    public static int[] colorNumberLine(int length, int[][] queries) {
        int[] colors = new int[length]; // Array to store colors of each coordinate
        Arrays.fill(colors, -1); // Initialize with -1 (indicating no color)
        int[] result = new int[queries.length];
        int consecutivePairs = 0;

        for (int i = 0; i < queries.length; i++) {
            int coord = queries[i][0];
            int color = queries[i][1];

            if (colors[coord] == color) {
                // If the coordinate is already this color, no change, store the same count
                result[i] = consecutivePairs;
                continue;
            }

            // Check and update the left neighbor
            if (coord > 0) {
                if (colors[coord - 1] == colors[coord]) {
                    consecutivePairs--;
                }
                if (colors[coord - 1] == color) {
                    consecutivePairs++;
                }
            }

            // Check and update the right neighbor
            if (coord < length - 1) {
                if (colors[coord + 1] == colors[coord]) {
                    consecutivePairs--;
                }
                if (colors[coord + 1] == color) {
                    consecutivePairs++;
                }
            }

            // Apply the new color
            colors[coord] = color;
            result[i] = consecutivePairs;
        }

        return result;
    }

    public static void main(String[] args) {
        int length = 7;
        int[][] queries = {
                {1, 2}, {0, 2}, {3, 5}, {3, 2}, {2, 2}, {6, 1}, {1, 3}
        };
        int[] output = colorNumberLine(length, queries);
        System.out.println(Arrays.toString(output));
    }
}
