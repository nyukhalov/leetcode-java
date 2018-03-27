package two_sum_ii_input_array_is_sorted;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pl = 0, pr = numbers.length - 1;

        while(numbers[pl] + numbers[pr] != target) {
            if (numbers[pl] + numbers[pr] > target) {
                pr--;
            } else {
                pl++;
            }
        }

        return new int[] { pl + 1, pr + 1};
    }
}