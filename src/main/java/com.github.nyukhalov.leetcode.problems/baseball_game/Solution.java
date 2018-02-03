package com.github.nyukhalov.leetcode.problems.baseball_game;

import java.util.*;

class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> points = new LinkedList<>();

        for (String op: ops) {
            switch(op) {
                case "C":
                    points.removeLast();
                    break;

                case "D":
                    int newPoint = points.getLast() * 2;
                    points.add(newPoint);
                    break;

                case "+":
                    Iterator<Integer> it = points.descendingIterator();
                    int last = it.next();
                    int beforeLast = it.next();
                    points.add(last + beforeLast);
                    break;

                default:
                    points.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int p: points) {
            sum += p;
        }

        return sum;
    }
}
