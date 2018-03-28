package majority_element;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/description/
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int result = 0;
        int occCount = 0;
        for (int n: nums) {
            int cnt = m.getOrDefault(n, 0) + 1;
            m.put(n, cnt);
            if (cnt > occCount) {
                occCount = cnt;
                result = n;
            }
        }
        return result;
    }
}
