package range_addition_ii;

// https://leetcode.com/problems/range-addition-ii/description/
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minA = m, minB = n;
        for (int[] row: ops) {
            if (row[0] < minA) minA = row[0];
            if (row[1] < minB) minB = row[1];
        }
        return minA * minB;
    }
}
