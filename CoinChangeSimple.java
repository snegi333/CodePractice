public class CoinChangeSimple {
    public static int countWays(int[] coins, int n, int sum) {
        // Base Cases
        if (sum == 0) return 1; // Found a valid way
        if (sum < 0 || n == 0) return 0; // Invalid case

        // Recursive calls:
        // 1. Include the coin (coins[n-1]) → Reduce sum but keep same n
        // 2. Exclude the coin → Move to the next coin (red uce n)
        return countWays(coins, n, sum - coins[n - 1]) + countWays(coins, n - 1, sum);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        int n = coins.length;
        System.out.println("Number of ways to make sum " + sum + " is: " + countWays(coins, n, sum));
    }
}