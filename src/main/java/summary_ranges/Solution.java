package summary_ranges;

import java.util.*;

// https://leetcode.com/problems/summary-ranges/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0) return ranges;

        int be = nums[0];
        int en = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (nums[i] != en + 1) {
                String range = getRange(be, en);
                ranges.add(range);
                be = en = nums[i];
            } else {
                en = nums[i];
            }
        }
        String range = getRange(be, en);
        ranges.add(range);
        return ranges;
    }

    private String getRange(int be, int en) {
        String range;
        if (be != en) {
            range = String.format("%d->%d", be, en);
        } else {
            range = String.format("%d", be);
        }
        return range;
    }
}
