package reverse_vowels_of_a_string;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
class Solution {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        reverseVowelsInPlace(chars);
        return new String(chars);
    }

    private boolean notVowel(char c) {
        return c != 'a' && c != 'e' && c != 'u' && c != 'i' && c != 'o' &&
                c != 'A' && c != 'E' && c != 'U' && c != 'I' && c != 'O';
    }

    private void reverseVowelsInPlace(char[] chars) {
        int lo = 0;
        int hi = chars.length - 1;
        while(true) {
            while(lo < chars.length && notVowel(chars[lo])) lo++;
            while(hi >= 0 && notVowel(chars[hi])) hi--;
            if (lo >= hi) break;
            char tmp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = tmp;
            lo++; hi--;
        }
    }
}
