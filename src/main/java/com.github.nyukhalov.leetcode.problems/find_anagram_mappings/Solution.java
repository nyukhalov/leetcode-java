package com.github.nyukhalov.leetcode.problems.find_anagram_mappings;

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> number2Bpos = new HashMap<>();
        
        for (int i=0; i<B.length; i++) {
            number2Bpos.put(B[i], i);
        }
        
        int[] P = new int[A.length];
        
        for (int i=0; i<A.length; i++) {
            P[i] = number2Bpos.get(A[i]);
        }
        
        return P;
    }
}
