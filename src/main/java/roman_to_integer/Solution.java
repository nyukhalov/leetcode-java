package roman_to_integer;

import java.util.*;

// https://leetcode.com/problems/roman-to-integer/description/
class Solution {
    private final static Map<Character, Integer> r2i = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int sum = 0;
        int prev = 0;
        for (int i=cs.length - 1; i >= 0; i--) {
            int n = r2i.get(cs[i]);
            if (n < prev) sum -= n;
            else sum += n;
            prev = n;
        }
        return sum;
    }
}
