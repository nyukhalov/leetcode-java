package string_compression;

// https://leetcode.com/problems/string-compression/
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int lastIdx = 0;
        char last = chars[lastIdx];
        int cnt = 1;
        int length = 0;

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == last) {
                cnt++;
            } else {
                if (cnt > 1) {
                    int len = 0;
                    char[] buff = new char[4];
                    while (cnt > 0) {
                        char d = (char) ('0' + (cnt % 10));
                        cnt /= 10;
                        buff[3 - len] = d;
                        len++;
                    }
                    for (int j = 4 - len; j < 4; j++) {
                        chars[lastIdx + 1] = buff[j];
                        lastIdx++;
                    }
                    length += len;
                }
                length++;
                lastIdx = length;
                chars[lastIdx] = c;
                cnt = 1;
                last = chars[lastIdx];
            }
        }
        length++;
        if (cnt > 1) {
            int len = 0;
            char[] buff = new char[4];
            while (cnt > 0) {
                char d = (char) ('0' + (cnt % 10));
                cnt /= 10;
                buff[3 - len] = d;
                len++;
            }
            for (int j = 4 - len; j < 4; j++) {
                chars[lastIdx + 1] = buff[j];
                lastIdx++;
            }
            length += len;
        }
        return length;
    }
}
