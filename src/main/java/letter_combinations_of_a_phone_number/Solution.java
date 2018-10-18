package letter_combinations_of_a_phone_number;

import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
class Solution {
    private static final Map<Character, List<Character>> mapping = new HashMap<Character, List<Character>>() {{
        put('2', Arrays.asList('a', 'b', 'c'));
        put('3', Arrays.asList('d', 'e', 'f'));
        put('4', Arrays.asList('g', 'h', 'i'));
        put('5', Arrays.asList('j', 'k', 'l'));
        put('6', Arrays.asList('m', 'n', 'o'));
        put('7', Arrays.asList('p', 'q', 'r', 's'));
        put('8', Arrays.asList('t', 'u', 'v'));
        put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }};

    public List<String> letterCombinations(String digits) {
        if (digits==null || "".equals(digits)) return Collections.emptyList();

        List<String> comb = new ArrayList<>();
        combinations("", digits, comb);
        return comb;
    }

    private void combinations(String prefix, String digits, List<String> comb) {
        if ("".equals(digits)) {
            comb.add(prefix);
            return;
        }
        char digit = digits.charAt(0);
        String digitTail = digits.substring(1);
        List<Character> chars = mapping.get(digit);
        for (char c: chars) {
            combinations(prefix + c, digitTail, comb);
        }
    }

}
