package shortest_distance_to_a_character;

// https://leetcode.com/problems/shortest-distance-to-a-character/description/
class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] s = S.toCharArray();
        int lastCIdx = -1;
        int[] result = new int[s.length];

        for (int i=0; i<s.length; i++) {
            if (s[i] == C) lastCIdx = i;
            if (lastCIdx != -1) {
                result[i] = Math.abs(i - lastCIdx);
            } else {
                result[i] = Integer.MAX_VALUE;
            }
        }

        lastCIdx = -1;
        for (int i=s.length - 1; i>=0; i--) {
            if (s[i] == C) lastCIdx = i;
            if (lastCIdx != -1) {
                int d = Math.abs(i - lastCIdx);
                result[i] = Math.min(result[i], d);
            }
        }

        return result;
    }
}
