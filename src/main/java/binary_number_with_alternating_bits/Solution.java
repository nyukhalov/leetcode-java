package binary_number_with_alternating_bits;

// https://leetcode.com/problems/binary-number-with-alternating-bits/description/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().hasAlternatingBits(5));
    }

    public boolean hasAlternatingBits(int n) {
        int right = 0;
        int nn = n;
        while(nn > 0) {
            right = right | nn;
            nn = nn >> 1;
        }
        int shifted = n >> 1;
        int left = shifted ^ n;
        return left == right;
    }
}
