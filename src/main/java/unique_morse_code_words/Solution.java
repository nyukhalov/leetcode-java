package unique_morse_code_words;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/unique-morse-code-words/description/
class Solution {
    private static final String[] morseCodes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    private static final Map<Character, String> c2morse = new HashMap<>();

    static {
        for (int i=0; i<morseCodes.length; i++) {
            char c = (char) ('a' + i);
            c2morse.put(c, morseCodes[i]);
        }
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> s = new HashSet<>();
        for (String w: words) {
            String t = transform(w);
            s.add(t);
        }
        return s.size();
    }

    private String transform(String w) {
        StringBuilder sb = new StringBuilder();
        for (char c: w.toCharArray()) {
            sb.append(c2morse.get(c));
        }
        return sb.toString();
    }
}
