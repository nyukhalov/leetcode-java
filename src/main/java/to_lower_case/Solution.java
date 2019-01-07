package to_lower_case;

// https://leetcode.com/problems/to-lower-case/
class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            sb.append(toLowerCase(str.charAt(i)));
        }
        return sb.toString();
    }

    private char toLowerCase(char c) {
        if ('A' <= c && c <= 'Z') {
            c = (char) (c - ('A' - 'a'));
        }
        return c;
    }
}
