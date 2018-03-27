package rotated_digits;

// https://leetcode.com/problems/rotated-digits/description/
class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int n=1; n<=N; n++) {
            int[] digits = toDigits(n);
            if (hasAtLeastOne2569(digits) && !hasAtLeastOne347(digits)) {
                res++;
            }
        }
        return res;
    }

    private int[] toDigits(int n) {
        int nd = (int) Math.log10(n) + 1;
        int digits[] = new int[nd];
        int cnt = 0;
        while(n > 9) {
            int d = n % 10;
            n /= 10;
            digits[cnt++] = d;
        }
        digits[cnt] = n;
        return digits;
    }

    private boolean hasAtLeastOne2569(int[] digits) {
        for (int n: digits) {
            if (n == 2 || n == 5 || n == 6 || n == 9) return true;
        }
        return false;
    }

    private boolean hasAtLeastOne347(int[] digits) {
        for (int n: digits) {
            if (n == 3 || n == 4 || n == 7) return true;
        }
        return false;
    }
}
