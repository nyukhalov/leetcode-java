package nim_game;

// https://leetcode.com/problems/nim-game/description/
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
