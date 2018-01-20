package com.github.nyukhalov.leetcode.problems.self_dividing_numbers;

import java.util.*;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int number = left; number <= right; number++) {
            if (isSelfDividingNumber(number)) {
                result.add(number);
            }
        }

        return result;
    }

    private boolean isSelfDividingNumber(int number) {
        boolean result = true;

        for (int d: getDigits(number)) {
            if (d == 0 || number % d != 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    private Set<Integer> getDigits(int number) {
        Set<Integer> result = new HashSet<>();

        number = Math.abs(number);

        while(number > 9) {
            int digit = number % 10;
            number = number / 10;
            result.add(digit);
        }

        result.add(number);

        return result;
    }
}
