package ransom_note;

// https://leetcode.com/problems/ransom-note/description/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] lettersCount = new int[26];
        for (char c: magazine.toCharArray()) {
            lettersCount[c - 'a']++;
        }
        for (char c: ransomNote.toCharArray()) {
            int cnt = --lettersCount[c - 'a'];
            if (cnt < 0) return false;
        }
        return true;
    }
}
