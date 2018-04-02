package sum_of_two_integers;

// https://leetcode.com/problems/sum-of-two-integers/description/
class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return getSum(a^b, (a&b) << 1);
    }
}
