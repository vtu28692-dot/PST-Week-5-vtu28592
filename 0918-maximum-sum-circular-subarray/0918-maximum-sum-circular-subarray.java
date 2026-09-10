class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxEnding = 0, minEnding = 0;
        int maxSum = nums[0], minSum = nums[0];

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane's algorithm for max subarray sum
            maxEnding = Math.max(num, maxEnding + num);
            maxSum = Math.max(maxSum, maxEnding);

            // Kadane's algorithm variant for min subarray sum
            minEnding = Math.min(num, minEnding + num);
            minSum = Math.min(minSum, minEnding);
        }

        // If all numbers are negative, totalSum - minSum == 0 (empty array scenario)
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}