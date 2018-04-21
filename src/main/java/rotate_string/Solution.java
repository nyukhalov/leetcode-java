package rotate_string;

// https://leetcode.com/problems/rotate-string/description/
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.isEmpty()) return true;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int idx = -1;
        while ((idx = findTheFirstOccOf(a[0], b, idx + 1)) != -1) {
            if (match(a, b, idx)) return true;
        }
        return false;
    }

    private int findTheFirstOccOf(char c, char[] where, int startFrom) {
        for (int i=startFrom; i<where.length; i++) {
            if (where[i] == c) return i;
        }
        return -1;
    }

    private boolean match(char[] s1, char[] s2, int s2offset) {
        for (int i=0; i<s1.length; i++) {
            int j = (s2offset + i) % s2.length;
            if (s1[i] != s2[j]) return false;
        }
        return true;
    }
}
