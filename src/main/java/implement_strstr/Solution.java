package implement_strstr;

// https://leetcode.com/problems/implement-strstr/
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) return 0;
        if (haystack == null || "".equals(haystack)) return -1;
        for (int i=0; i<=haystack.length() - needle.length(); i++) {
            boolean eq = true;
            for (int j=0; j<needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    eq = false;
                    break;
                }
            }
            if (eq) return i;
        }
        return -1;
    }
}
