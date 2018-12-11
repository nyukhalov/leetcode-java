package basic_calculator;

import java.util.*;

// https://leetcode.com/problems/basic-calculator/
class Solution {

    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (isDigit(cur)) {
                int num = cur - '0';
                while(i + 1 < s.length() && isDigit(s.charAt(i + 1))) {
                    num = 10 * num + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sign * num;
            } else if (cur == '+') {
                sign = 1;
            } else if (cur == '-') {
                sign = -1;
            } else if (cur == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (cur == ')') {
                sign = stack.pop();
                result = result * sign + stack.pop();
            }
        }

        return result;
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}