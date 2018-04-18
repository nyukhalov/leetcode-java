package number_of_lines_to_write_string;

// https://leetcode.com/problems/number-of-lines-to-write-string/description/
class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        final int maxWidth = 100;
        int lines = 1;
        int curWidth = 0;
        int[] result = new int[2];

        for (char c: S.toCharArray()) {
            int w = widths[c - 'a'];
            if (curWidth + w <= 100) {
                curWidth += w;
            } else {
                curWidth = w;
                lines++;
            }
        }

        result[0] = lines;
        result[1] = curWidth;
        return result;
    }
}
