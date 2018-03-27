package intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-arrays/description/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        int[] smallest;
        int[] largest;
        if (nums1.length < nums2.length) {
            smallest = nums1;
            largest = nums2;
        } else {
            smallest = nums2;
            largest = nums1;
        }
        Set<Integer> s = new HashSet<>();
        for (int e: smallest) {
            s.add(e);
        }

        Set<Integer> result = new HashSet<>();
        for (int e: largest) {
            if (s.contains(e)) result.add(e);
        }
        int[] resArr = new int[result.size()];
        int cnt = 0;
        for (int e: result) {
            resArr[cnt++] = e;
        }
        return resArr;
    }
}
