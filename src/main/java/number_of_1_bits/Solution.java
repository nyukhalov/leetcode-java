package number_of_1_bits;

// https://leetcode.com/problems/number-of-1-bits/description/
public class Solution {
    public static void main(String[] args) {
        //   2147483648 (10000000000000000000000000000000)
        new Solution().hammingWeight(2147483647 + 1);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;

        int pot = 1;
        for (int i=0; i<32; i++) {
            if ((n & pot) != 0) {
                weight += 1;
            }
            pot = pot << 1;
        }
        return weight;
    }
}
