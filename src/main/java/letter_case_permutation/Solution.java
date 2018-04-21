package letter_case_permutation;

import java.util.*;

// https://leetcode.com/problems/letter-case-permutation/description/
class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] s = S.toCharArray();
        List<String> result = new ArrayList<>();
        result.add(S);
        permutate(result, s, 0);
        return result;
    }

    private void permutate(List<String> result, char[] s, int startFrom) {
        if (startFrom >= s.length) return;
        permutate(result, s, startFrom + 1);
        char c = s[startFrom];
        if (isLetter(c)) {
            s[startFrom] = switchLetterCase(c);
            result.add(toString(s));
            permutate(result, s, startFrom + 1);
            s[startFrom] = c;
        }
    }

    private boolean isLetter(char c) {
        return c >= 'A' && c <= 'z';
    }

    private char switchLetterCase(char c) {
        boolean isLowercase = c >= 'a' && c <= 'z';
        int diff = 'A' - 'a';
        if (isLowercase) c += diff;
        else c -= diff;
        return c;
    }

    private String toString(char[] s) {
        return new String(s);
    }
}
