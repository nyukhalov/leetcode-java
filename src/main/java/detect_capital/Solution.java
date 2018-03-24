package detect_capital;

import java.util.*;

// https://leetcode.com/problems/detect-capital/description/
class Solution {

    static abstract class WordCorrectnessCriteria {
        abstract boolean isCorrect(String word);

        boolean isUpperCase(char c) {
            return c >= 'A' && c <= 'Z';
        }

        boolean isLowerCase(char c) {
            return c >= 'a' && c <= 'z';
        }
    }

    static class AllUpperCaseCriteria extends WordCorrectnessCriteria {
        @Override
        public boolean isCorrect(String word) {
            for (char c: word.toCharArray()) {
                if (isLowerCase(c)) return false;
            }
            return true;
        }
    }

    static class AllLowerCaseCriteria extends WordCorrectnessCriteria {
        @Override
        public boolean isCorrect(String word) {
            for (char c: word.toCharArray()) {
                if (isUpperCase(c)) return false;
            }
            return true;
        }
    }

    static class StartsWithCapitalCriteria extends WordCorrectnessCriteria {
        @Override
        public boolean isCorrect(String word) {
            char[] chars = word.toCharArray();
            if (isLowerCase(chars[0])) return false;
            for (int i=1; i<chars.length; i++) {
                if (isUpperCase(chars[i])) return false;
            }
            return true;
        }
    }

    static List<WordCorrectnessCriteria> criterias = new ArrayList<WordCorrectnessCriteria>() {{
        add(new AllUpperCaseCriteria());
        add(new AllLowerCaseCriteria());
        add(new StartsWithCapitalCriteria());
    }};

    public boolean detectCapitalUse(String word) {
        for (WordCorrectnessCriteria c: criterias) {
            if (c.isCorrect(word)) return true;
        }
        return false;
    }
}
