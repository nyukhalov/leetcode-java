package license_key_formatting;

// https://leetcode.com/problems/license-key-formatting/
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int nDashes = getNumDashes(S);
        int nLetters = S.length() - nDashes;
        int nPrefix = nLetters % K;

        StringBuilder sb = new StringBuilder();
        int sIdx = 0;
        boolean isFirst = false;

        while(nPrefix > 0) {
            char c = S.charAt(sIdx++);
            if (c != '-') {
                isFirst = true;
                nPrefix--;
                sb.append(toUpperCase(c));
            }
        }

        int cnt = 0;
        for(int i=sIdx; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c != '-') {
                if (isFirst || (cnt != 0 && cnt % K == 0)) {
                    isFirst = false;
                    sb.append('-');
                }
                cnt++;
                sb.append(toUpperCase(c));
            }
        }

        return sb.toString();
    }

    private char toUpperCase(char c) {
        if ('a' <= c && c <= 'z') {
            c += 'A' - 'a';
        }
        return c;
    }

    private int getNumDashes(String s) {
        int sum = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '-') sum++;
        }
        return sum;
    }
}
