package reverse_bits;

// https://leetcode.com/problems/reverse-bits/description/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i=0; i<16; i++) {
            int lastBit = 1 << (31 - i);
            int bit = 1 << i;

            boolean ithIsZero = (n & bit) == 0;
            boolean lastIsZero = (n & lastBit) == 0;

            // set the ith as last
            if (lastIsZero) {
                n = n & ~(n & bit); // set it as 0
            } else {
                n = n | bit;
            }

            if (ithIsZero) {
                n = n & ~(n & lastBit); // set it as 0
            } else {
                n = n | lastBit;
            }
        }
        return n;
    }
}
