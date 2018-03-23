package com.github.nyukhalov.leetcode.problems.distribute_candies;

import java.util.*;

// https://leetcode.com/problems/distribute-candies/description/
class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> candyKind = new HashSet<>();
        for (int c: candies) {
            candyKind.add(c);
        }
        return Math.min(candies.length / 2, candyKind.size());
    }
}
