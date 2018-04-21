package find_the_difference;

// https://leetcode.com/problems/find-the-difference/description/
class Solution {
    public char findTheDifference(String s, String t) {
        int sumOfSCodes = sumOfStringCodes(s);
        int sumOfTCodes = sumOfStringCodes(t);
        return (char) ('0' + (sumOfTCodes - sumOfSCodes));
    }

    private int sumOfStringCodes(String s) {
        int result = 0;
        for (char c: s.toCharArray()) {
            result += c - '0';
        }
        return result;
    }
}
