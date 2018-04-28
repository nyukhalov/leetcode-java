package degree_of_an_array;

import java.util.*;

// https://leetcode.com/problems/degree-of-an-array/description/
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> num2startIdx = new HashMap<>();
        Map<Integer, Integer> num2endIdx = new HashMap<>();
        Map<Integer, Integer> num2cnt = new HashMap<>();

        int maxCnt = Integer.MIN_VALUE;
        int length = 0;
        for (int i=0; i<nums.length; i++) {
            int cnt = num2cnt.getOrDefault(nums[i], 0) + 1;
            if (cnt == 1) { // first occurence
                num2startIdx.put(nums[i], i);
            } else {
                num2endIdx.put(nums[i], i);
            }

            int startIdx = num2startIdx.get(nums[i]);
            int l = num2endIdx.getOrDefault(nums[i], startIdx) - startIdx + 1;
            if (cnt > maxCnt || (cnt == maxCnt && l < length)) {
                maxCnt = cnt;
                length = l;
            }
            num2cnt.put(nums[i], cnt);
        }
        return length;
    }
}
