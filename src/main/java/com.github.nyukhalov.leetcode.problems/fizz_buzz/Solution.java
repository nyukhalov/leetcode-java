package com.github.nyukhalov.leetcode.problems.fizz_buzz;

import java.util.*;

// https://leetcode.com/problems/fizz-buzz/description/
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean isMultipliesOfThree = (i % 3) == 0;
            boolean isMultipliesOfFive = (i % 5) == 0;

            if (isMultipliesOfThree && isMultipliesOfFive) {
                result.add("FizzBuzz");
            } else if (isMultipliesOfThree) {
                result.add("Fizz");
            } else if (isMultipliesOfFive) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
}
