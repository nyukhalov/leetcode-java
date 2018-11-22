package spiral_matrix;

import java.util.*;

// https://leetcode.com/problems/spiral-matrix/
class Solution {
    // r, c
    int[][] offsets = new int[][] {
            new int[] { 0, 1 }, // right
            new int[] { 1, 0 }, // down
            new int[] { 0, -1 }, // left
            new int[] { -1, 0 } // up
    };

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();

        int dir = 0; // direction
        int wCounter = matrix[0].length;
        int hCounter = matrix.length - 1;

        int r = 0;
        int c = -1;

        while(true) {
            int[] offset = offsets[dir];
            int cnt = 0;
            boolean isW = offset[0] == 0;
            if (isW) cnt = wCounter;
            else cnt = hCounter;
            if (cnt == 0) break;
            while(cnt-- > 0) {
                r += offset[0];
                c += offset[1];
                ret.add(matrix[r][c]);
            }
            if (isW) wCounter--;
            else hCounter--;
            dir = (dir + 1) % 4;
        }

        return ret;
    }
}
