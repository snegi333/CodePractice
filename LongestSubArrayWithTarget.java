import java.util.*;
public class LongestSubArrayWithTarget {

    public static int longestSubArrayWithTarget(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLength = 0;
        while (right<arr.length){
            sum = sum + arr[right];
            while (sum>target){
                sum = sum - arr[left];
                left++;
            }
            if(sum==target){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }

        return maxLength;



//        int maxLength = 0;
//        int currentSum = 0;
//        Map<Integer, Integer> sumIndexMap = new HashMap<>();
//        sumIndexMap.put(0, -1); // To handle the case when the subarray starts from index 0
//
//        for (int i = 0; i < arr.length; i++) {
//            currentSum += arr[i];
//
//            // Check if there is a subarray with the required sum
//            if (sumIndexMap.containsKey(currentSum - target)) {
//                int startIndex = sumIndexMap.get(currentSum - target);
//                maxLength = Math.max(maxLength, i - startIndex);
//            }
//
//            // Store the first occurrence of the current sum
//            if (!sumIndexMap.containsKey(currentSum)) {
//                sumIndexMap.put(currentSum, i);
//            }
//        }
//
//        return maxLength;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 15;
        System.out.println("Longest subarray with sum " + target + ": " + longestSubArrayWithTarget(arr, target));
    }
}
