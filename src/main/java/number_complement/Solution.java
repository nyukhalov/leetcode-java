package number_complement;

class Solution {
    public int findComplement(int num) {
        boolean facedNonZeroBit = false;
        for (int offset = 31; offset >= 0; offset--) {
            int bit = (1 << offset);
            if ((num & bit) != 0) {
                facedNonZeroBit = true;
                num = num ^ bit;
            } else {
                if (facedNonZeroBit) {
                    num = num | bit;
                }
            }
        }
        return num;
    }
}
