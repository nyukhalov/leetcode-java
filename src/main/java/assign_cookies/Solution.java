package assign_cookies;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/description/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, cockieIdx = 0, kidIdx = 0;
        while (cockieIdx < s.length && kidIdx < g.length) {
            if (s[cockieIdx] >= g[kidIdx]) {
                res++;
                kidIdx++;
            }
            cockieIdx++;
        }
        return res;
    }
}
