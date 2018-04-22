package binary_watch;

import java.util.*;

// https://leetcode.com/problems/binary-watch/description/
class Solution {
    private static Map<Integer, List<Integer>> hourBits2Hours = new HashMap<>();
    private static Map<Integer, List<Integer>> minuteBits2Hours = new HashMap<>();

    static {
        for (int h = 0; h<=11; h++) {
            int bitsCnt = getBitsCnt(h);
            List<Integer> hours = hourBits2Hours.get(bitsCnt);
            if (hours == null) {
                hours = new ArrayList<>();
                hourBits2Hours.put(bitsCnt, hours);
            }
            hours.add(h);
        }

        for (int m=0; m<=59; m++) {
            int bitsCnt = getBitsCnt(m);
            List<Integer> minutes = minuteBits2Hours.get(bitsCnt);
            if (minutes == null) {
                minutes = new ArrayList<>();
                minuteBits2Hours.put(bitsCnt, minutes);
            }
            minutes.add(m);
        }
    }

    private static int getBitsCnt(int num) {
        int bits = 0;
        int bit = 1;
        while (bit <= num) {
            if ((num & bit) != 0) bits++;
            bit <<= 1;
        }
        return bits;
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int hourBits = 0; hourBits<=num; hourBits++) {
            int minuteBits = num - hourBits;
            List<Integer> possibleHours = getPossibleHours(hourBits);
            List<Integer> possibleMinutes = getPossibleMinutes(minuteBits);
            for (Integer hour: possibleHours) {
                for (Integer minute: possibleMinutes) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return result;
    }

    private List<Integer> getPossibleHours(int hourBits) {
        List<Integer> result = hourBits2Hours.get(hourBits);
        if (result == null) return Collections.emptyList();
        return result;
    }

    private List<Integer> getPossibleMinutes(int minuteBits) {
        List<Integer> result = minuteBits2Hours.get(minuteBits);
        if (result == null) return Collections.emptyList();
        return result;
    }
}
