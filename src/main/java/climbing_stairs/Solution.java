package climbing_stairs;

import java.util.*;

// https://leetcode.com/problems/climbing-stairs/description/
class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return nrOfClimbStairs(0, n, memo);
    }

    private int nrOfClimbStairs(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];
        memo[i] = nrOfClimbStairs(i + 1, n, memo) + nrOfClimbStairs(i + 2, n, memo);
        return memo[i];
    }
}
