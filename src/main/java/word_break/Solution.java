package word_break;

import java.util.*;

// https://leetcode.com/problems/word-break/description/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        Set<String> notbreakable = new HashSet<>();
        for (String word: wordDict) dict.add(word);
        return wordBreak(s, dict, notbreakable);
    }

    private boolean wordBreak(String s, Set<String> wordDict, Set<String> notbreakable) {
        if (s == null || "".equals(s)) return true;
        if (wordDict.contains(s)) return true;
        if (notbreakable.contains(s)) return false;
        for (int i=1; i<s.length(); i++) {
            String ss = s.substring(0, i);
            if (wordDict.contains(ss)) {
                String tail = s.substring(i);
                if (wordBreak(tail, wordDict, notbreakable)) return true;
            }
        }
        notbreakable.add(s);
        return false;
    }
}
