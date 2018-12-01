package remove_invalid_parentheses;

import java.util.*;

// https://leetcode.com/problems/remove-invalid-parentheses/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || "".equals(s)) {
            List<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }

        if (isValid(s)) {
            List<String> ret = new ArrayList<>();
            ret.add(s);
            return ret;
        }

        Set<String> candidates = new HashSet<>();
        candidates.add(s);
        Set<String> mutations = new HashSet<>();
        Set<String> results = new HashSet<>();

        while(results.isEmpty()) {
            mutations.clear();
            for (String candidate: candidates) {
                mutations.addAll(mutateByRemovingParenthes(candidate));
                for (String m: mutations) {
                    if (isValid(m)) results.add(m);
                }
            }
            Set<String> tmp = candidates;
            candidates = mutations;
            mutations = tmp;
        }

        List<String> ret = new ArrayList<>();
        ret.addAll(results);
        return ret;
    }

    private Set<String> mutateByRemovingParenthes(String s) {
        Set<String> ret = new HashSet<>();
        if (s.length() == 1) ret.add("");
        else {
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                    if (i == 0) {
                        ret.add(s.substring(1));
                    } else if (i == s.length() - 1) {
                        ret.add(s.substring(0, s.length() - 1));
                    } else {
                        String mutation = s.substring(0, i) + s.substring(i + 1);
                        ret.add(mutation);
                    }
                }
            }
        }
        return ret;
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                if (cnt <= 0) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }
}
