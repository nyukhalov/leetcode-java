package happy_number;

// https://leetcode.com/problems/happy-number/description/
class Solution {
    public boolean isHappy(int n) {
        while(n > 9) {
            n = squaredSumOfDigits(n);
        }
        return (n == 7 || n == 1);
    }

    private int squaredSumOfDigits(int n) {
        int sum = 0;
        while(n > 9) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        sum += n * n;
        return sum;
    }
}
