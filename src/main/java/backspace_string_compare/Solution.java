package backspace_string_compare;

import java.util.*;

// https://leetcode.com/problems/backspace-string-compare/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!stackS.isEmpty()) stackS.pop();
            }
            else stackS.push(c);
        }
        for(int i=0; i<T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (!stackT.isEmpty()) stackT.pop();
            }
            else stackT.push(c);
        }
        if (stackS.size() != stackT.size()) return false;
        while(!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) return false;
        }
        return true;
    }
}
