package add_strings;

// https://leetcode.com/problems/add-strings/description/
class Solution {
    public String addStrings(String num1, String num2) {
        char[] cnum1 = num1.toCharArray();
        char[] cnum2 = num2.toCharArray();
        if (cnum2.length > cnum1.length) {
            char[] tmp = cnum1;
            cnum1 = cnum2;
            cnum2 = tmp;
        }
        char[] result = addChars(cnum1, cnum2);
        return new String(result);
    }

    private char[] addChars(char[] cnum1, char[] cnum2) {
        int add = 0;
        for (int i = 0; i < cnum1.length; i++) {
            int sum = add + (cnum1[cnum1.length - i - 1] - '0');
            if (i < cnum2.length) sum += (cnum2[cnum2.length - i - 1] - '0');
            cnum1[cnum1.length - i - 1] = (char) ('0' + (sum % 10));
            add = sum / 10;
        }
        if (add == 0) return cnum1;
        char[] result = new char[cnum1.length + 1];
        result[0] = (char) ('0' + add);
        for (int i=0; i<cnum1.length; i++) result[i + 1] = cnum1[i];
        return result;
    }
}
