package count_and_say;

// https://leetcode.com/problems/count-and-say/description/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }

    public String countAndSay(int n) {
        String output = "1";
        while(n-- > 1) {
            output = countAndSayIter(output);
        }
        return output;
    }

    private String countAndSayIter(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int cnt = 0;
        for (int i=0; i<cs.length; i++) {
            if (i>0 && cs[i] != cs[i-1]) {
                sb.append(cnt);
                sb.append(cs[i - 1]);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        sb.append(cnt);
        sb.append(cs[cs.length - 1]);
        return sb.toString();
    }
}
