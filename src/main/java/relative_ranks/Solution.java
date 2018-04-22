package relative_ranks;

import java.util.*;

// https://leetcode.com/problems/relative-ranks/description/
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> score2rank = new HashMap<>();
        for (int i=0; i<sorted.length; i++) {
            score2rank.put(sorted[i], nums.length - i);
        }
        String[] result = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            int rank = score2rank.get(nums[i]);
            String text;
            switch (rank) {
                case 1:
                    text = "Gold Medal";
                    break;
                case 2:
                    text = "Silver Medal";
                    break;
                case 3:
                    text = "Bronze Medal";
                    break;

                default:
                    text = Integer.toString(rank);
                    break;
            }
            result[i] = text;
        }
        return result;
    }
}
