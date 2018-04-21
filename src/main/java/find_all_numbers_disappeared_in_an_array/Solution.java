package find_all_numbers_disappeared_in_an_array;

import java.util.*;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int idx = 0, num = 1; num <= nums.length;) {
            int el = nums[idx];
            if (el > num) {
                result.add(num);
                num++;
            } else if (el == num) {
                if (idx < nums.length - 1) idx++;
                num++;
            } else if (el < num) {
                if (idx < nums.length - 1) idx++;
                else {
                    result.add(num);
                    num++;
                }
            }
        }
        return result;
    }
}
