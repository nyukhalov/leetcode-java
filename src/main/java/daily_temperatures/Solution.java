package daily_temperatures;

import java.util.*;

// https://leetcode.com/problems/daily-temperatures/description/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> temps = new Stack<>();
        Stack<Integer> indexes = new Stack<>();

        for (int i=0; i<temperatures.length; i++) {
            int t = temperatures[i];
            while(!temps.isEmpty() && temps.peek() < t) {
                temps.pop();
                int idx = indexes.pop();
                result[idx] = i - idx;
            }
            temps.push(t);
            indexes.push(i);
        }

        return result;
    }
}
