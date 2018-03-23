package reverse_words_in_a_string_iii;

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (Character c: s.toCharArray()) {
            if (c == ' ') {
                printAndCleanStack(stack, sb);
                sb.append(c);
            } else {
                stack.push(c);
            }
        }
        printAndCleanStack(stack, sb);
        return sb.toString();
    }

    private void printAndCleanStack(Stack<Character> s, StringBuilder sb) {
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        s.clear();
    }
}
