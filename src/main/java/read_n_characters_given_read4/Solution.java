package read_n_characters_given_read4;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

// https://leetcode.com/problems/read-n-characters-given-read4/
class Reader4 {
    int read4(char[] buf) {
        return 0;
    }
}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int left = n;
        boolean finished = false;
        char[] buf4 = new char[4];
        while(!finished) {
            int nRead = read4(buf4);
            int toCopy = Math.min(left, nRead);
            System.arraycopy(buf4, 0, buf, n - left, toCopy);
            left -= toCopy;
            finished = nRead < 4 || left <= 0;
        }
        return n - left;
    }
}
