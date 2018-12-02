package queue_reconstruction_by_height;

import java.util.*;

// https://leetcode.com/problems/queue-reconstruction-by-height/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int idx = 0;
        while(idx < people.length) {
            int nHigher = countHigherPeople(people, idx);
            int target = people[idx][1];
            if (nHigher != target) {
                int diff = target - nHigher;
                shiftRight(people, idx, diff);
            } else {
                idx++;
            }
        }
        return people;
    }

    private int countHigherPeople(int[][] people, int idx) {
        int cnt = 0;
        for (int i=idx - 1; i>=0; i--) {
            if (people[i][0] >= people[idx][0]) cnt++;
        }
        return cnt;
    }

    private void shiftRight(int[][] people, int idx, int diff) {
        while(diff > 0) {
            int k = idx + 1;
            while(people[idx][0] > people[k][0]) k++;
            int[] tmp = people[idx];
            people[idx] = people[k];
            people[k] = tmp;
            diff--;
            idx = k;
        }
    }
}
