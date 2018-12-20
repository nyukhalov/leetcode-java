package shortest_unsorted_continuous_subarray;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int be = 0;
        while(be < nums.length && isSmallest(be, nums)) be++;
        int en = nums.length - 1;
        while(en > be && isBiggest(en, nums)) en--;
        return en - be + 1;
    }

    private boolean isSmallest(int idx, int[] nums) {
        for(int i=idx + 1; i < nums.length; i++) {
            if (nums[i] < nums[idx]) return false;
        }
        return true;
    }

    private boolean isBiggest(int idx, int[] nums) {
        for(int i=idx - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) return false;
        }
        return true;
    }
}
