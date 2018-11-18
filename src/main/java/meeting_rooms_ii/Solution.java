package meeting_rooms_ii;

class Solution {

    /**
     * Definition for an interval.
     */
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {
        int[] deltas = getDeltas(intervals);
        int maxSimultMeetings = findMaxSimultMeetings(deltas);
        return maxSimultMeetings;
    }

    private int[] getDeltas(Interval[] intervals) {
        int minStartTime = findMinStartTime(intervals);
        int maxStartTime = findMaxStartTime(intervals);
        int [] deltas = new int[maxStartTime - minStartTime + 1];
        for (Interval i: intervals) {
            addDelta(deltas, i.start - minStartTime, 1);
            addDelta(deltas, i.end - minStartTime, -1);
        }
        return deltas;
    }

    private int findMaxSimultMeetings(int[] deltas) {
        int maxSimultMeetings = 0;
        int runningSum = 0;
        for (int d: deltas) {
            runningSum += d;
            if (runningSum > maxSimultMeetings) {
                maxSimultMeetings = runningSum;
            }
        }
        return maxSimultMeetings;
    }

    private int findMinStartTime(Interval[] intervals) {
        int minStartTime = Integer.MAX_VALUE;
        for (Interval i: intervals) {
            if (i.start < minStartTime) {
                minStartTime = i.start;
            }
        }
        return minStartTime;
    }

    private int findMaxStartTime(Interval[] intervals) {
        int maxStartTime = Integer.MIN_VALUE;
        for (Interval i: intervals) {
            if (i.start > maxStartTime) {
                maxStartTime = i.start;
            }
        }
        return maxStartTime;
    }

    private void addDelta(int[] deltas, int idx, int value) {
        if (idx >= 0 && idx < deltas.length) {
            deltas[idx] += value;
        }
    }
}
