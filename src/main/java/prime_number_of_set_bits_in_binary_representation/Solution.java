package prime_number_of_set_bits_in_binary_representation;

import java.util.*;

// https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
class Solution {
    private final static Set<Integer> primes = new HashSet<Integer>() {{
        add(2);
        add(3);
        add(5);
        add(7);
        add(11);
        add(13);
        add(17);
        add(19);
        add(23);
        add(29);
        add(31);
    }};

    public static void main(String[] args) {
        new Solution().countPrimeSetBits(842, 888);
    }

    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int n=L; n<=R; n++) {
            int setBits = nrOfSetBits(n);
            if (isPrime(setBits)) result++;
        }
        return result;
    }

    private int nrOfSetBits(int n) {
        int res = 0;
        int bit = 1;
        while (bit <= n) {
            if ((n & bit) != 0) res++;
            bit <<= 1;
        }
        return res;
    }

    private boolean isPrime(int n) {
        return primes.contains(n);
    }
}
