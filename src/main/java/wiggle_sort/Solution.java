package wiggle_sort;

// https://leetcode.com/problems/wiggle-sort/
class Solution {
    public void wiggleSort(int[] nums) {
        for (int i=0; i<nums.length - 1; i++) {
            if (isCorrect(nums, i)) continue;
            swap(nums, i, i+1);
        }
    }

    private boolean isCorrect(int[] nums, int i) {
        if (i % 2 == 0) return nums[i + 1] >= nums[i];
        else return nums[i + 1] <= nums[i];
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
