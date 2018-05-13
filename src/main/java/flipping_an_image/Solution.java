package flipping_an_image;

// https://leetcode.com/problems/flipping-an-image/description/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int row = 0; row < A.length; row++) {
            flipAndInvertRow(A[row]);
        }
        return A;
    }

    private void flipAndInvertRow(int[] row) {
        for (int col = 0; col < row.length / 2; col++) {
            int tmp = row[col];
            row[col] = row[row.length - col - 1];
            row[row.length - col - 1] = tmp;
        }
        for (int col = 0; col < row.length; col++) {
            row[col] = 1 - row[col];
        }
    }
}
