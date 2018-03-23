package keyboard_row;

import java.util.*;

class Solution {
    private static Map<Character, Integer> char2row = new HashMap<Character, Integer>() {{
        put('q', 1);
        put('w', 1);
        put('e', 1);
        put('r', 1);
        put('t', 1);
        put('y', 1);
        put('u', 1);
        put('i', 1);
        put('o', 1);
        put('p', 1);

        put('a', 2);
        put('s', 2);
        put('d', 2);
        put('f', 2);
        put('g', 2);
        put('h', 2);
        put('j', 2);
        put('k', 2);
        put('l', 2);

        put('z', 3);
        put('x', 3);
        put('c', 3);
        put('v', 3);
        put('b', 3);
        put('n', 3);
        put('m', 3);
    }};

    public String[] findWords(String[] words) {
        ArrayList<String> al = new ArrayList<>();
        for (String w: words) {
            if (isOneRowWord(w)) {
                al.add(w);
            }
        }
        return al.toArray(new String[0]);
    }

    private boolean isOneRowWord(String w) {
        if (w == null || w == "") return true;

        char[] cs = w.toLowerCase().toCharArray();
        int row = char2row.get(cs[0]);
        boolean result = true;

        for (int i=1; i<cs.length; i++) {
            if (char2row.get(cs[i]) != row) {
                result = false;
                break;
            }
        }

        return result;
    }
}
