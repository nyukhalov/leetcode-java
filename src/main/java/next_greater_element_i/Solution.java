package next_greater_element_i;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/next-greater-element-i/description/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> el2idx = new HashMap<>();
        for (int i=0; i<nums2.length; i++) {
            el2idx.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int idx = el2idx.get(nums1[i]);
            int greater = -1;
            for (int j = idx + 1; j<nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    greater = nums2[i];
                    break;
                }
            }
            result[i] = greater;

        }
        return result;
    }
}
