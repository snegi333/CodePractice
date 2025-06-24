public class StaircaseWaysDP {
    public static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static void main(String[] args) {
        int stairs = 4;
        System.out.println("Ways to reach stair " + stairs + ": " + countWays(stairs));
    }
}
