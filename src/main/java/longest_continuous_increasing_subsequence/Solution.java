package longest_continuous_increasing_subsequence;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int l = 0;
        for (int i=0; i<nums.length; i++) {
            if (l == 0 || nums[i] > nums[i-1]) l++;
            else {
                if (l > res) res = l;
                l = 1;
            }
        }
        if (l > res) res = l;
        return res;
    }
}
