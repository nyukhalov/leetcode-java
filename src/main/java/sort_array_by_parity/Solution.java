package sort_array_by_parity;

// https://leetcode.com/problems/sort-array-by-parity/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int be = 0;
        int en = A.length - 1;
        while(be < en) {
            while(be < A.length && A[be] % 2 == 0) be++;
            while(en >= 0 && A[en] % 2 != 0) en--;
            if (be < en) {
                int tmp = A[be];
                A[be] = A[en];
                A[en] = tmp;
            }
            be++;
            en--;
        }
        return A;
    }
}
