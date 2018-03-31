package power_of_two;

// https://leetcode.com/problems/power-of-two/description/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int powerOfTwo = 1;
        while(powerOfTwo > 0 && powerOfTwo < n) powerOfTwo = powerOfTwo << 1;
        return powerOfTwo == n;
    }
}
