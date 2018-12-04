package find_all_anagrams_in_a_string;

import java.util.*;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s.length() < p.length()) return ret;

        int[] sLetters = new int[26];
        int[] pLetters = new int[26];
        for (int i=0; i<p.length(); i++) {
            sLetters[s.charAt(i) - 'a']++;
            pLetters[p.charAt(i) - 'a']++;
        }

        if (isAnagram(sLetters, pLetters)) ret.add(0);

        for (int i=1; i<s.length() - p.length() + 1; i++) {
            sLetters[s.charAt(i - 1) - 'a']--;
            sLetters[s.charAt(i + p.length() - 1) - 'a']++;
            if (isAnagram(sLetters, pLetters)) ret.add(i);
        }

        return ret;
    }

    private boolean isAnagram(int[] sLetters, int[] pLetters) {
        for (int i=0; i<sLetters.length; i++) {
            if (sLetters[i] != pLetters[i]) return false;
        }
        return true;
    }
}
