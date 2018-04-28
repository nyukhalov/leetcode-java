package reverse_string_ii;

// https://leetcode.com/problems/reverse-string-ii/description/
class Solution {
    public static void main(String[] args) {
        new Solution().reverseStr("abcdefg", 2);
    }

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        for (int i=0; i<cs.length; i+= 2 * k) {
            int from = i;
            int to = Math.min(i + k - 1, cs.length - 1);
            reverseChars(cs, from, to);
        }
        return new String(cs);
    }

    private void reverseChars(char[] cs, int from, int to) {
        int middle = (to - from) / 2;
        for (int i=0; i<=middle; i++) {
            char tmp = cs[from + i];
            cs[from + i] = cs[to - i];
            cs[to - i] = tmp;
        }
    }
}
