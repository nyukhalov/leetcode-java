package count_binary_substrings;

// https://leetcode.com/problems/count-binary-substrings/description/
class Solution {
    public int countBinarySubstrings(String s) {
        char[] ar = s.toCharArray();
        int count = 0;
        for (int i=0; i<ar.length;) {
            char startWith = ar[i];
            int firstPartLength = 0;
            int secondPartLength = 0;
            boolean firstPart = true;
            for (int j=i; j<ar.length; j++) {
                if (firstPart) {
                    if (ar[j] == startWith) firstPartLength++;
                    else {
                        firstPart = false;
                        secondPartLength++;
                        if (firstPartLength == secondPartLength) break;
                    }
                } else {
                    if (ar[j] == startWith) break;
                    secondPartLength++;
                    if (firstPartLength == secondPartLength) break;
                }
            }
            if (firstPartLength == secondPartLength) {
                count += firstPartLength;
                i += firstPartLength;
            } else {
                i += Math.abs(firstPartLength - secondPartLength);
            }
        }
        return count;
    }
}
