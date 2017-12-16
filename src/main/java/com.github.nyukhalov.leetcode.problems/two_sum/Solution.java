package com.github.nyukhalov.leetcode.problems.two_sum;

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {        
        Map<Integer, Integer> num2idx = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (num2idx.containsKey(complement)) {
                return new int[] {num2idx.get(complement), i};
            }
            num2idx.put(nums[i], i);
        }
                
        throw new IllegalArgumentException("Bad input");
    }
}