package decode_ways;

import java.util.*;

// https://leetcode.com/problems/decode-ways/
class Solution {
    public int numDecodings(String s) {
        int memo[] = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodings(s, 0, memo);
    }

    private int numDecodings(String s, int from, int[] memo) {
        if (s.length() - from <= 0) return 1;

        char cur = s.charAt(from);
        // invalid string
        if (cur == '0') return 0;

        if (s.length() - from == 1) return 1;

        int res = memo[from];
        if (res >= 0) return res;

        char next = s.charAt(from + 1);

        res = 0;
        if (next != '0') {
            int n = numDecodings(s, from + 1, memo);
            res += n;
        }
        if (cur == '1') {
            int n = numDecodings(s, from + 2, memo);
            res += n;
        }
        if (cur == '2' && ('0' <= next && next <= '6')) {
            int n = numDecodings(s, from + 2, memo);
            res += n;
        }
        memo[from] = res;
        return res;
    }
}
