package excel_sheet_column_number;

// https://leetcode.com/problems/excel-sheet-column-number/description/
class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i<s.length(); result = result * 26 + s.charAt(i) - 'A' + 1, i++) {}
        return result;
    }
}
