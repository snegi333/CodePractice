import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static int DFS(int[] arr, int left, int right, int sum, Map<String, Integer> dp) {
        if (left >= right) return 0;

        String key = left + "," + right;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int ans = 0;

        if (left + 1 < arr.length && arr[left] + arr[left + 1] == sum) {
            ans = 1 + DFS(arr, left + 2, right, sum, dp);
        }

        if (arr[left] + arr[right] == sum) {
            ans = Math.max(ans, 1 + DFS(arr, left + 1, right - 1, sum, dp));
        }

        if (right - 1 >= 0 && arr[right] + arr[right - 1] == sum) {
            ans = Math.max(ans, 1 + DFS(arr, left, right - 2, sum, dp));
        }

        dp.put(key, ans);
        return ans;
    }

    public static int solution(int[] A) {
        Map<String, Integer> dp = new HashMap<>();
        int n = A.length;
        if (n < 2) return 0;

        int ans = DFS(A, 0, n - 1, A[0] + A[1], dp);
        dp.clear();
        ans = Math.max(ans, DFS(A, 0, n - 1, A[0] + A[n - 1], dp));
        dp.clear();
        ans = Math.max(ans, DFS(A, 0, n - 1, A[n - 1] + A[n - 2], dp));

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {0,0,0}; // Example input
        System.out.println(solution(A));
    }
}
