package subsets;

import java.util.*;

// https://leetcode.com/problems/subsets/description/
class Solution {
    private static class State {
        List<Integer> nums;
        int ridx;
        public State(List<Integer> nums, int ridx) {
            this.nums = nums;
            this.ridx = ridx;
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        // initial state: [], -1
        State st = new State(new ArrayList<>(), -1);
        List<List<Integer>> result = new ArrayList<>();
        doSubsets(result, st, nums);
        return result;
    }

    private void doSubsets(List<List<Integer>> result, State st, int[] nums) {
        result.add(st.nums);
        for (int i=st.ridx + 1; i<nums.length; i++) {
            List<Integer> newNums = new ArrayList<>(st.nums);
            newNums.add(nums[i]);
            State newState = new State(newNums, i);
            doSubsets(result, newState, nums);
        }
    }
}
