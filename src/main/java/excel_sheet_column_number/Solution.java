package excel_sheet_column_number;

// https://leetcode.com/problems/excel-sheet-column-number/description/
class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i>=0; i--) {
            int pos = chars.length - i - 1;
            int volume = chars[i] - 'A' + 1;
            volume = volume * (int) Math.pow(26, pos);
            sum += volume;
        }
        return sum;
    }
}
