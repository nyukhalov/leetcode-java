package merge_intervals;

import java.util.*;
import java.math.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

// https://leetcode.com/problems/merge-intervals/description/
class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Solution::compare);
        List<Interval> merged = new ArrayList<>();
        for (int i = 0; i < intervals.size(); ) {
            Interval interval = intervals.get(i);
            int nMerged = 1; // the number of merged intervals
            for (; i + nMerged < intervals.size(); nMerged++) {
                Interval c = intervals.get(i + nMerged); // candidate
                if (!intersects(interval, c)) break;
                interval = mergeIntervals(interval, c);
            }
            merged.add(interval);
            i += nMerged;
        }

        return merged;
    }

    private static int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
    }

    private boolean intersects(Interval i1, Interval i2) {
        return (i1.start >= i2.start && i1.start <= i2.end) ||
                (i1.end >= i2.start && i1.end <= i2.end) ||
                (i2.start >= i1.start && i2.start <= i1.end) ||
                (i2.end >= i1.start && i2.end <= i1.end);
    }

    private Interval mergeIntervals(Interval i1, Interval i2) {
        return new Interval(
                Math.min(i1.start, i2.start),
                Math.max(i1.end, i2.end)
        );
    }
}
