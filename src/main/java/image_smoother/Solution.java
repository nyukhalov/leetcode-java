package image_smoother;

// https://leetcode.com/problems/image-smoother/description/
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][];
        for (int i=0; i<M.length; i++) res[i] = new int[M[0].length];
        for (int r = 0; r<M.length; r++) {
            for(int c = 0; c<M[0].length; c++) {
                int participants = 1;
                int sum = M[r][c];
                if (r - 1 >= 0) {
                    participants++;
                    sum += M[r - 1][c];
                    if (c - 1 >= 0) {
                        participants++;
                        sum += M[r - 1][c - 1];
                    }
                    if (c + 1 < M[0].length) {
                        participants++;
                        sum += M[r - 1][c + 1];
                    }
                }
                if (c - 1 >= 0) {
                    participants++;
                    sum += M[r][c - 1];
                }
                if (c + 1 < M[0].length) {
                    participants++;
                    sum += M[r][c + 1];
                }
                if (r + 1 < M.length) {
                    participants++;
                    sum += M[r + 1][c];
                    if (c - 1 >= 0) {
                        participants++;
                        sum += M[r + 1][c - 1];
                    }
                    if (c + 1 < M[0].length) {
                        participants++;
                        sum += M[r + 1][c + 1];
                    }
                }
                res[r][c] = sum / participants;
            }
        }
        return res;
    }
}
