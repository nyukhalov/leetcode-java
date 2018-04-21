package missing_number;

// https://leetcode.com/problems/missing-number/description/
class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int i: nums) sum += i;
        return expectedSum - sum;
    }
}
