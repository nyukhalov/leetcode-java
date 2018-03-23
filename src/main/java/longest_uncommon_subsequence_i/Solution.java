package longest_uncommon_subsequence_i;

class Solution {
    public int findLUSlength(String a, String b) {
        int al = a.length();
        int bl = b.length();
        if (al == bl) {
            if (a.equals(b)) return -1;
            else return al;
        } else {
            return Math.max(al, bl);
        }
    }
}
