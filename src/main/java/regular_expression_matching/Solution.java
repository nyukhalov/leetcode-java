package regular_expression_matching;

// https://leetcode.com/problems/regular-expression-matching/
class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, memo);
    }

    private boolean isMatch(String s, String p, int sPos, int pPos, Boolean[][] memo) {
        int pRemains = p.length() - pPos;
        int sRemains = s.length() - sPos;
        if (pRemains <= 0) return sRemains <= 0;

        Boolean ret = null;

        ret = memo[sPos][pPos];
        if (ret != null) return ret;

        boolean firstMatch = sRemains > 0 && (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '.');

        if (pRemains >= 2 && p.charAt(pPos + 1) == '*') {
            ret = isMatch(s, p, sPos, pPos + 2, memo) ||
                    (firstMatch && isMatch(s, p, sPos + 1, pPos, memo));
        } else {
            ret = firstMatch && isMatch(s, p, sPos + 1, pPos + 1, memo);
        }

        memo[sPos][pPos] = ret;
        return ret;
    }
}