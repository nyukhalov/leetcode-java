package find_pivot_index;

// https://leetcode.com/problems/find-pivot-index/
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++) totalSum += nums[i];

        int lSum = 0;
        int rSum = totalSum;
        for(int i=0; i<nums.length; i++) {
            rSum -= nums[i];
            if (lSum == rSum) return i;
            lSum += nums[i];
        }
        return -1;
    }
}
