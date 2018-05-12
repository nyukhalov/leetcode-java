package pascals_triangle;

import java.util.*;

// https://leetcode.com/problems/pascals-triangle/description/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int r=0; r<numRows; r++) {
            int cols = r + 1; // number of columns | row length
            List<Integer> row = new ArrayList<>(cols);
            row.add(1);
            for (int c=1; c<cols-1; c++) {
                List<Integer> prevRow = result.get(r - 1);
                row.add(prevRow.get(c - 1) + prevRow.get(c));
            }
            if (r != 0) row.add(1);
            result.add(row);
        }
        return result;
    }
}
