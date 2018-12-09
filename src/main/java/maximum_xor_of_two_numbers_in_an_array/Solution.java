package maximum_xor_of_two_numbers_in_an_array;

// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor > maxXor) maxXor = xor;
            }
        }
        return maxXor;
    }
}