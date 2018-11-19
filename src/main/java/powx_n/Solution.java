package powx_n;

// https://leetcode.com/problems/powx-n/
class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0) return 1.0;
        if (x == -1) {
            if (n % 2 == 0) return 1.0;
            else return -1.0;
        }
        if (n < 0) {
            if (n < -1022) return 0;
            return 1.0 / myPow(x, -n);
        }

        double result = 1;
        while (n > 0) {
            int k = 2;
            double ret = x;
            double prevRet = ret;
            for(; k<=n; k *= 2) {
                prevRet = ret;
                ret = ret*ret;
                if (ret == prevRet) return ret;
            }
            result *= ret;
            n -= k / 2;
        }

        return result;
    }
}
