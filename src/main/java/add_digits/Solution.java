package add_digits;

// https://leetcode.com/problems/add-digits/description/
public class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while(num > 0) {
            int digit = num % 10;
            num = num / 10;
            sum += digit;
            if (sum > 9) sum -= 9;
        }
        return sum;
    }
}
