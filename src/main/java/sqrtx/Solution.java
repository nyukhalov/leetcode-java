package sqrtx;

// https://leetcode.com/problems/sqrtx/description/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(1978959248));
    }

    public int mySqrt(int x) {
        if (x < 2) return x;
        return mySqrtRec(x, 1, Math.min(x / 2, 46340));
    }

    private int mySqrtRec(int x, int be, int en) {
        int mid = be + (en - be) / 2;
        long midSquared = (long) mid * (long) mid;
        long nextSquared = (long) (mid + 1) * (long) (mid + 1);
        long prevSquared = (long) (mid - 1) * (long) (mid - 1);
        if (prevSquared < x && midSquared <= x && nextSquared > x) return mid;
        else if (midSquared < x) return mySqrtRec(x, mid + 1, en);
        else return mySqrtRec(x, be, mid - 1);
    }
}
