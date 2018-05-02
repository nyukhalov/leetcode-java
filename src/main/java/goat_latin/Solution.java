package goat_latin;

import java.util.*;

class Solution {
    private final Set<Character> vowels = new HashSet<>();

    {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        if (words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<words.length - 1; i++) {
            sb.append(convertWord(words[i], i + 1));
            sb.append(" ");
        }
        sb.append(convertWord(words[words.length - 1], words.length));
        return sb.toString();
    }

    private String convertWord(String word, int position) {
        StringBuilder sb = new StringBuilder();
        if (vowels.contains(word.charAt(0))) {
            sb.append(word);
        } else {
            sb.append(word.substring(1));
            sb.append(word.charAt(0));
        }
        sb.append("ma");
        while(position-- > 0) sb.append("a");
        return sb.toString();
    }
}
