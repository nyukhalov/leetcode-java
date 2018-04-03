package merge_sorted_array;

import java.util.*;

// https://leetcode.com/problems/merge-sorted-array/description/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        mergeSort(nums1, nums1Copy, nums2, n);
    }

    private void mergeSort(int[] out, int[] nums1, int[] nums2, int n) {
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < nums1.length && i2 < n) {
            int el;
            if (nums1[i1] < nums2[i2]) {
                el = nums1[i1];
                i1++;
            } else {
                el = nums2[i2];
                i2++;
            }
            out[i++] = el;
        }
        for (; i1 < nums1.length; i1++, i++) {
            out[i] = nums1[i1];
        }
        for (; i2 < n; i2++, i++) {
            out[i] = nums2[i2];
        }
    }
}
