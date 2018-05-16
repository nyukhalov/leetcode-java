package house_robber;

import java.util.*;

// https://leetcode.com/problems/house-robber/description/
class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robNth(memo, nums, 0);
    }

    private int robNth(int[] memo, int[] nums, int n) {
        if (n >= nums.length) return 0;
        if (memo[n] != -1) return memo[n];
        return memo[n] = Math.max(
                nums[n] + robNth(memo, nums, n + 2),
                robNth(memo, nums, n + 1)
        );
    }
}
