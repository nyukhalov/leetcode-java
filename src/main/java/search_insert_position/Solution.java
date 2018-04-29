package search_insert_position;

// https://leetcode.com/problems/search-insert-position/description/
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int from = 0;
        int to = nums.length - 1;
        int offset = 0;
        while(from < to) {
            int middle = from + (to - from) / 2;
            int el = nums[middle];
            if (el == target) return middle;
            if (el < target) from = middle + 1;
            if (el > target) to = middle - 1;
        }
        if (target > nums[from]) return from + 1;
        else return from;
    }
}
