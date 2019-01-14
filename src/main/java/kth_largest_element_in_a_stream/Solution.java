package kth_largest_element_in_a_stream;

import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class Solution {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public Solution(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for(int n: nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (minHeap.size() >= k) {
            if (val > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(val);
            }
        } else {
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}
