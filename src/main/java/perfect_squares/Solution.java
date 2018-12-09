package perfect_squares;

import java.util.*;

// https://leetcode.com/problems/perfect-squares/
class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return numSquares(n, memo);
    }

    private int numSquares(int n, int[] memo) {
        int ret = memo[n];
        if (ret != Integer.MAX_VALUE) return ret;

        if (n < 4) return n;
        int sqrt = (int) (Math.sqrt(n));
        if (sqrt * sqrt == n) {
            memo[n] = 1;
            return 1;
        }

        int minNumSquares = Integer.MAX_VALUE;
        while(sqrt > 0) {
            int square = sqrt * sqrt;
            int nSquares = 1 + numSquares(n - square, memo);
            if (nSquares < minNumSquares) minNumSquares = nSquares;
            sqrt--;
        }

        memo[n] = minNumSquares;
        return minNumSquares;
    }
}