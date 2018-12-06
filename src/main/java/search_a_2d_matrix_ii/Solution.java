package search_a_2d_matrix_ii;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int cbe = 0;
        int cen = matrix[0].length - 1;
        int rbe = 0;
        int ren = matrix.length - 1;
        return searchMatrix(matrix, target, rbe, ren, cbe, cen);
    }

    private boolean searchMatrix(int[][] matrix, int target, int rbe, int ren, int cbe, int cen) {
        if (rbe < 0 || ren < 0 || cbe < 0 || cen < 0 || ren < rbe || cen < cbe) return false;
        if (ren - rbe <= 2 && cen - cbe <= 2) {
            for (int r=rbe; r<=ren; r++) {
                for (int c=cbe; c<=cen; c++) {
                    if (matrix[r][c] == target) return true;
                }
            }
            return false;
        }
        int rmid = rbe + (ren - rbe) / 2;
        int cmid = cbe + (cen - cbe) / 2;
        if (matrix[rmid][cmid] == target) return true;
        if (matrix[rmid][cmid] > target) {
            //return searchMatrix(matrix, target, rbe, rmid, cbe, cmid);
            return searchMatrix(matrix, target, rbe, ren, cbe, cmid - 1) ||
                    searchMatrix(matrix, target, rbe, rmid - 1, cmid, cen);
        } else {
            //return searchMatrix(matrix, target, rmid, ren, cmid, cen);
            return searchMatrix(matrix, target, rmid + 1, ren, cbe, cen) ||
                    searchMatrix(matrix, target, rbe, rmid, cmid + 1, cen);
        }
    }
}
