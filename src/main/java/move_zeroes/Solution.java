package move_zeroes;

// https://leetcode.com/problems/move-zeroes/description/
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        int lastNonZeroIdx = findFirstNonZeroBackwards(nums);
        for (;;) {
            zeroIdx = findFirstZero(nums, zeroIdx);
            if (zeroIdx >= lastNonZeroIdx) return;
            move(nums, zeroIdx, lastNonZeroIdx);
            lastNonZeroIdx--;
        }
    }

    private int findFirstZero(int[] nums, int startedFrom) {
        int i = startedFrom;
        while (i < nums.length - 1 && nums[i] != 0) i++;
        return i;
    }

    private int findFirstNonZeroBackwards(int[] nums) {
        int i = nums.length - 1;
        while(i > 0 && nums[i] == 0) i--;
        return i;
    }

    private void move(int[] nums, int from, int to) {
        for (int i=from; i<to; i++) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}