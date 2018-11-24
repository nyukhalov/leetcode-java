package valid_palindrome;

// https://leetcode.com/problems/valid-palindrome/
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        int be = moveRight(s, -1);
        int en = moveLeft(s, s.length());
        while(be < en) {
            if (!equalIgnoredCase(s.charAt(be), s.charAt(en))) return false;
            be = moveRight(s, be);
            en = moveLeft(s, en);
        }
        return true;
    }

    private boolean equalIgnoredCase(char a, char b) {
        a = toLowercase(a);
        b = toLowercase(b);
        return a == b;
    }

    private char toLowercase(char c) {
        if ('A' <= c && c <= 'Z') return (char) (c - 'A' + 'a');
        return c;
    }

    private int moveRight(String s, int pos) {
        pos++;
        while(pos < s.length() && !isAlphanumeric(s.charAt(pos))) pos++;
        return pos;
    }

    private int moveLeft(String s, int pos) {
        pos--;
        while(pos >= 0 && !isAlphanumeric(s.charAt(pos))) pos--;
        return pos;
    }

    private boolean isAlphanumeric(char c) {
        return ('a' <= c && c <= 'z') ||
                ('A' <= c && c <= 'Z') ||
                ('0' <= c && c <= '9');
    }
}
