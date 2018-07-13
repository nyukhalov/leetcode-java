package palindromic_substrings;

// https://leetcode.com/problems/palindromic-substrings/description/
public class Solution {
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        Boolean[][] cache = new Boolean[cs.length][];
        for (int i=0; i<cs.length; i++) {
            cache[i] = new Boolean[cs.length];
        }
        int res = 0;
        for (int i=0; i<cs.length; i++) {
            for (int j=i; j<cs.length; j++) {
                if (isPolindrome(cache, cs, i, j)) res++;
            }
        }
        return res;
    }

    private boolean isPolindrome(Boolean[][] cache, char[] cs, int be, int en) {
        if (be >= en) return true;
        if (cache[be][en] != null) return cache[be][en];
        boolean res = cs[be] == cs[en] && isPolindrome(cache, cs, be + 1, en - 1);
        cache[be][en] = res;
        return res;
    }
}
