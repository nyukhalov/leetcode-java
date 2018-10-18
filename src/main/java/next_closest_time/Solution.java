package next_closest_time;

import java.util.*;

// https://leetcode.com/problems/next-closest-time/
class Solution {
    static class Time implements Comparable<Time> {
        int hours;
        int minutes;
        int totalMinutes;

        public Time(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
            this.totalMinutes = 60*hours + minutes;
        }

        @Override
        public int compareTo(Time t) {
            return Integer.compare(this.totalMinutes, t.totalMinutes);
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", hours, minutes);
        }
    }

    String nextClosestTime(String timeStr) {
        Time time = parseTime(timeStr);
        int[] digits = parseDigits(timeStr);
        List<Time> combinations = buildTimeCombinations(digits);
        return findClosest(time, combinations).toString();
    }

    Time parseTime(String timeStr) {
        String[] tokens = timeStr.split(":");
        int hours = Integer.valueOf(tokens[0]);
        int minutes = Integer.valueOf(tokens[1]);
        return new Time(hours, minutes);
    }

    int[] parseDigits(String timeStr) {
        int[] digits = new int[4];
        digits[0] = timeStr.charAt(0) - '0';
        digits[1] = timeStr.charAt(1) - '0';
        digits[2] = timeStr.charAt(3) - '0';
        digits[3] = timeStr.charAt(4) - '0';
        return digits;
    }

    List<Time> buildTimeCombinations(int[] digits) {
        List<Time> comb = new ArrayList<>();
        for (int i=0; i<digits.length; i++) {
            for (int j=0; j<digits.length; j++) {
                int hours = 10*digits[i] + digits[j];
                if (hours > 23) continue;
                for (int k=0; k<digits.length; k++) {
                    for (int l=0; l<digits.length; l++) {
                        int minutes = 10*digits[k] + digits[l];
                        if (minutes <= 59) comb.add(new Time(hours, minutes));
                    }
                }
            }
        }
        return comb;
    }

    Time findClosest(Time orig, List<Time> candidates) {
        Collections.sort(candidates);
        for (Time time: candidates) {
            if (time.compareTo(orig) > 0) return time;
        }
        return candidates.get(0);
    }
}
