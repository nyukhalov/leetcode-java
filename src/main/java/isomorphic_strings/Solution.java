package isomorphic_strings;

import java.util.*;

// https://leetcode.com/problems/isomorphic-strings/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> replacement = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        int size = s.length();
        for(int i=0; i<size; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            // t - original, doesn't change
            Character r = replacement.get(sc);
            if (r == null) {
                if (!mapped.contains(tc)) {
                    replacement.put(sc, tc);
                    mapped.add(tc);
                } else {
                    return false;
                }
            } else {
                if (!r.equals(tc)) return false;
            }
        }
        return true;
    }
}
