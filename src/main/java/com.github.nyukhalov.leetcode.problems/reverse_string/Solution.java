package com.github.nyukhalov.leetcode.problems.reverse_string;

class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
}
