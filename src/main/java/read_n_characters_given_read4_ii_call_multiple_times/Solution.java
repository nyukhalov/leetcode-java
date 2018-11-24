package read_n_characters_given_read4_ii_call_multiple_times;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

class Reader4 {
    int read4(char[] buf) {
        return 0;
    }
}

// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
public class Solution extends Reader4 {

    char[] buffer = new char[4];
    int nBuffLen = 0;
    int bOffset = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int left = n;
        while(left > 0) {
            int nRead = doRead(buf, n - left, left);
            if (nRead <= 0) break;
            left -= nRead;
        }
        return n - left;
    }

    private int doRead(char[] buf, int offset, int n) {
        if (isBufferEmpty()) {
            refillBuffer();
        }
        if (isBufferEmpty()) return 0;
        int available = getAvailable();
        int toCopy = Math.min(n, available);
        System.arraycopy(buffer, bOffset, buf, offset, toCopy);
        bOffset += toCopy;
        return toCopy;
    }

    private boolean isBufferEmpty() {
        return nBuffLen <= 0 || bOffset >= nBuffLen;
    }

    private int getAvailable() {
        return nBuffLen - bOffset;
    }

    private void refillBuffer() {
        nBuffLen = read4(buffer);
        bOffset = 0;
    }
}
