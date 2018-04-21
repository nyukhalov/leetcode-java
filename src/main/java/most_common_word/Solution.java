package most_common_word;

import java.util.*;

// https://leetcode.com/problems/most-common-word/description/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> allWords = parseWords(paragraph);
        List<String> normWords = filterAndTransformToLowerCase(allWords, banned);
        Map<String, Integer> word2count = new HashMap<>();
        String result = null;
        int maxCount = -1;
        for (String w: normWords) {
            int count = word2count.getOrDefault(w, 0) + 1;
            word2count.put(w, count);
            if (count > maxCount) {
                result = w;
                maxCount = count;
            }
        }
        return result;
    }

    private List<String> parseWords(String s) {
        List<String> result = new ArrayList<>();
        for (String w: s.split("[!?',;. ]")) {
            if (!w.equals("") && !w.equals(" ")) {
                result.add(w);
            }
        }
        return result;
    }

    private List<String> filterAndTransformToLowerCase(List<String> l, String[] banned) {
        Set<String> bs = new HashSet<>();
        for (String s: banned) {
            bs.add(s.toLowerCase());
        }
        List<String> result = new ArrayList<>();
        for (String s: l) {
            String ls = s.toLowerCase();
            if (bs.contains(ls)) continue;
            result.add(ls);
        }
        return result;
    }
}
