public class MaxProfitStock {
    public static int maxProfit(int[] Arr) {
        if (Arr == null || Arr.length == 0) return 0;
        // Write your code here.
        int maxProfit = 0;
        int minPrice = Arr[0];

        for (int i = 1; i < Arr.length; i++) {
            int curProfit = Arr[i] - minPrice;
            maxProfit = Math.max(maxProfit, curProfit);
            minPrice = Math.min(minPrice, Arr[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices1)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + maxProfit(prices2)); // Output: 0 (no profit)
    }
}
