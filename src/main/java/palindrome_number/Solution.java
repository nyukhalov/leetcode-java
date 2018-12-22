package palindrome_number;

// https://leetcode.com/problems/palindrome-number/
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int nDigits = 1 + (int) Math.log10(x);
        int[] digits = new int[nDigits];
        for(int i=0; i<digits.length; i++) {
            int v = x % 10;
            x = x / 10;
            digits[i] = v;
        }
        for(int i=0; i<digits.length / 2; i++) {
            if (digits[i] != digits[digits.length - i - 1]) return false;
        }
        return true;
    }
}
