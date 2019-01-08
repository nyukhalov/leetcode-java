package moving_average_from_data_stream;

import java.util.*;

// https://leetcode.com/problems/moving-average-from-data-stream/
class MovingAverage {

    private Queue<Integer> queue;
    private int sum = 0;
    private int maxWin;
    private int size = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.maxWin = size;
    }

    public double next(int val) {
        if (size >= maxWin) {
            size--;
            int old = queue.remove();
            sum -= old;
        }
        size++;
        queue.add(val);
        sum += val;
        return (double) sum / (double) size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
