package maximum_subarray;

// https://leetcode.com/problems/maximum-subarray/description/
class Solution {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxSum = nums[0];
        int curSum = maxSum;

        for (int i=1; i<nums.length; i++) {
            int nextSum = curSum + nums[i];
            if (nextSum <= 0) curSum = nums[i];
            else curSum = Math.max(nextSum, nums[i]);

            if (curSum > maxSum) maxSum = curSum;
        }

        return maxSum;
    }
}
