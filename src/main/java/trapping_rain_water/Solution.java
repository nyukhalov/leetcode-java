package trapping_rain_water;

// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int be = 0;
        int en = height.length - 1;
        while(be < height.length && height[be] == 0) be++;
        while(en >= 0 && height[en] == 0) en--;
        if (en - be == 0) return 0;
        return trap(height, be, en);
    }

    private int trap(int[] height, int be, int en) {
        if (en - be < 2) return 0;
        int max = height[be];
        int maxIdx = be;
        int max2 = 0;
        int max2Idx = 0;

        for (int i=be + 1; i<=en; i++) {
            if (height[i] > max) {
                max2 = max;
                max2Idx = maxIdx;
                max = height[i];
                maxIdx = i;
            } else if (height[i] > max2) {
                max2 = height[i];
                max2Idx = i;
            }
        }

        // swap so that max2 if always on the right
        if (max2Idx < maxIdx) {
            int tmp = max;
            int tmpIdx = maxIdx;
            max = max2;
            maxIdx = max2Idx;
            max2 = tmp;
            max2Idx = tmpIdx;
        }
        int trapVal = calcTrap(height, maxIdx, max2Idx);
        return trapVal + trap(height, be, maxIdx) + trap(height, max2Idx, en);
    }

    private int calcTrap(int[] height, int be, int en) {
        int level = Math.min(height[be], height[en]);
        int ret = 0;
        for (int i=be + 1; i<en; i++) {
            ret += level - height[i];
        }
        return ret;
    }
}
