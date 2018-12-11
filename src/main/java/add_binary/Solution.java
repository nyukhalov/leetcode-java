package add_binary;

// https://leetcode.com/problems/add-binary/
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int maxLen = Math.max(a.length(), b.length());
        int add = 0;
        for (int i=0; i<maxLen; i++) {
            int ai = 0;
            if (i < a.length()) {
                ai = a.charAt(a.length() - i - 1) - '0';
            }
            int bi = 0;
            if (i < b.length()) {
                bi = b.charAt(b.length() - i - 1) - '0';
            }

            int sum = (ai + bi + add) % 2;
            sb.append(sum);

            add = (ai + bi + add) / 2;
        }

        if (add > 0) {
            sb.append(add);
        }

        sb.reverse();
        return sb.toString();
    }
}