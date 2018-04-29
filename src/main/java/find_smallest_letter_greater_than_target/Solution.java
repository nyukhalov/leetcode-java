package find_smallest_letter_greater_than_target;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char r = letters[0];
        int i=0;
        while (i<letters.length && letters[i] <= target) i++;
        if (i < letters.length) r = letters[i];
        return r;
    }
}
