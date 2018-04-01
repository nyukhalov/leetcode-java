package valid_parentheses;

import java.util.*;

// https://leetcode.com/problems/valid-parentheses/description/
class Solution {
    // opening to closing
    private final static Map<Character, Character> validBraces = new HashMap<Character, Character>() {{
        put('[', ']');
        put('{', '}');
        put('(', ')');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char o = stack.pop();
                if (notCompleteBraces(o, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpening(char c) {
        return validBraces.containsKey(c);
    }

    private boolean notCompleteBraces(char opening, char closing) {
        return validBraces.get(opening) != closing;
    }
}
