package rotate_array;

// https://leetcode.com/problems/rotate-array/
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        while(k-- > 0) {
            rotateRight(nums);
        }
    }

    private void rotateRight(int[] nums) {
        int prev = nums[0];
        for (int i=1; i<nums.length; i++) {
            int tmp = nums[i];
            nums[i] = prev;
            prev = tmp;
        }
        nums[0] = prev;
    }
}
