package longest_common_prefix;

// https://leetcode.com/problems/longest-common-prefix/description/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        boolean shouldContinue = true;
        StringBuilder sb = new StringBuilder();

        int minLength = Integer.MAX_VALUE;
        for (String s: strs) minLength = Math.min(minLength, s.length());
        if (strs.length == 0) minLength = 0;

        for (int idx=0; shouldContinue && idx<minLength; idx++) {
            for(int i=1; i<strs.length; i++) {
                String s = strs[i];
                if (s.charAt(idx) != strs[i - 1].charAt(idx)) {
                    shouldContinue = false;
                    break;
                }
            }
            if (shouldContinue) {
                sb.append(strs[0].charAt(idx));
            }
        }
        return sb.toString();
    }
}
