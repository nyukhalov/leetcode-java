package factorial_trailing_zeroes;

// https://leetcode.com/problems/factorial-trailing-zeroes/description/
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (; n>0; res += n/5, n /= 5) {}
        return res;
    }
}
