package merge_sorted_array;

// https://leetcode.com/problems/merge-sorted-array/description/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int i1 = m - 1, i2 = n - 1;
        while(i1 >= 0 && i2 >= 0) {
            int el;
            if (nums1[i1] > nums2[i2]) {
                el = nums1[i1--];
            } else {
                el = nums2[i2--];
            }
            nums1[i--] = el;
        }
        while(i2 >= 0) {
            nums1[i--] = nums2[i2--];
        }
    }
}
