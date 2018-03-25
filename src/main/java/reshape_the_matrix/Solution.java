package reshape_the_matrix;

// https://leetcode.com/problems/reshape-the-matrix/description/
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (reshapeImpossible(nums, r, c)) {
            return nums;
        }

        return reshape(nums, r, c);
    }

    private boolean reshapeImpossible(int[][] nums, int r, int c) {
        return nums.length * nums[0].length != r * c;
    }

    private int[][] reshape(int[][] nums, int r, int c) {
        int[][] reshaped = new int[r][];
        for (int i=0; i<r; i++) {
            reshaped[i] = new int[c];
        }

        int el = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums[i].length; j++) {
                int rr = (el / c);
                int rc = (el % c);
                reshaped[rr][rc] = nums[i][j];
                el++;
            }
        }

        return reshaped;
    }
}
