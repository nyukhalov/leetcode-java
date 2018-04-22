package first_unique_character_in_a_string;

// https://leetcode.com/problems/first-unique-character-in-a-string/description/
class Solution {
    public int firstUniqChar(String s) {
        int[] lettersCount = new int[26];
        char[] letters = s.toCharArray();
        for (char c: letters) {
            lettersCount[c - 'a']++;
        }
        for (int i=0; i<letters.length; i++) {
            if (lettersCount[letters[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
