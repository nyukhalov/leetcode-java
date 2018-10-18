package next_permutation;

import java.util.*;

// https://leetcode.com/problems/next-permutation/description/
class Solution {
    public void nextPermutation(int[] nums) {
        for (int i=nums.length-2; i>=0; i--) {
            for (int j=nums.length-1; j>i; j--) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    Arrays.sort(nums, i+1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
