package com.github.nyukhalov.leetcode.problems.toeplitz_matrix;

import java.util.*;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int r=0; r<matrix.length; r++) {
            for (int c=0; c<matrix[0].length; c++) {
                int groupKey = r - c;
                if (groups.containsKey(groupKey)) {
                    if (groups.get(groupKey) != matrix[r][c]) return false;
                } else {
                    groups.put(groupKey, matrix[r][c]);
                }
            }
        }
        return true;
    }
}
