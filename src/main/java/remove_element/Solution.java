package remove_element;

// https://leetcode.com/problems/remove-element/description/
class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int next = 0; next < nums.length; next++) {
            if (nums[next] != val) nums[i++] = nums[next];
        }
        return i;
    }
}
