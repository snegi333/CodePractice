import java.util.*;

public class MinimumCostPermutation {

    // Function to calculate the cost of a given permutation
    public static int calculateCost(int[] arr) {
        Set<Integer> distinctElements = new HashSet<>();
        int cost = 0;

        for (int num : arr) {
            distinctElements.add(num);
            cost += distinctElements.size();
        }

        return cost;
    }

    // Function to find the minimum cost among all permutations
    public static int findMinimumCost(int[] arr) {
        Arrays.sort(arr); // Sort the array for lexicographic permutations
        int minCost = Integer.MAX_VALUE;

        do {
            int cost = calculateCost(arr);
            minCost = Math.min(minCost, cost);
        } while (nextPermutation(arr));

        return minCost;
    }

    // Function to generate the next lexicographic permutation
    public static boolean nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // Swap elements at i and j
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Reverse the suffix
        reverse(arr, i + 1, n - 1);
        return true;
    }

    // Helper function to reverse the array from start to end indices
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        int[] arr = {2, 2, 3};
        int minCost = findMinimumCost(arr);
        System.out.println("Minimum cost: " + minCost);
    }
}
