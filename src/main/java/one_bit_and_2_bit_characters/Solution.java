package one_bit_and_2_bit_characters;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
    public boolean isOneBitCharacter(int[] bits) {
        boolean lastIsOneBit = false;
        for (int i=0; i<bits.length; i++) {
            if (bits[i] == 1) {
                lastIsOneBit = false;
                i++;
            } else {
                lastIsOneBit = true;
            }
        }
        return lastIsOneBit;
    }
}
