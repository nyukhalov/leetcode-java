package hamming_distance;

class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        for (int i=0; i<31; i++) {
            int ithBit = 1 << i;
            if ((xor & ithBit) != 0) res++;
        }
        return res;
    }
}
