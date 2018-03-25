package max_consecutive_ones;

// https://leetcode.com/problems/max-consecutive-ones/description/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSeqLen = 0;
        int curSeqLen = 0;

        for (int num : nums) {
            if (num == 0) {
                if (curSeqLen > maxSeqLen) maxSeqLen = curSeqLen;
                curSeqLen = 0;
            } else {
                curSeqLen++;
            }
        }

        if (curSeqLen > maxSeqLen) maxSeqLen = curSeqLen;

        return maxSeqLen;
    }
}
