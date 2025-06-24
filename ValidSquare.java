import java.util.*;

public class ValidSquare {

    // Helper method to calculate square of distance between two points
    private static int distSq(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Put all points in an array for easy iteration
        int[][] points = {p1, p2, p3, p4};
        Set<Integer> distances = new HashSet<>();

        // Calculate all 6 pairwise distances
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int d = distSq(points[i], points[j]);
                if (d == 0) return false; // overlapping points
                distances.add(d);
            }
        }

        // For a valid square: exactly 2 distinct non-zero distances (side and diagonal)
        return distances.size() == 2;
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4)); // true

        int[] q1 = {0, 0}, q2 = {1, 1}, q3 = {1, 0}, q4 = {0, 12};
        System.out.println(validSquare(q1, q2, q3, q4)); // false
    }
}