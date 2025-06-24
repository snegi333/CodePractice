public class MaximumSubarraySum {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];       // maximum subarray sum found so far
        int currentMax = nums[0];     // max subarray ending at current position

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start new from current element
            currentMax = currentMax + nums[i];
            if(currentMax<0){
                currentMax=0;
            }
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}
