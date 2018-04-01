package min_stack;

import java.util.*;

// https://leetcode.com/problems/min-stack/description/
class MinStack {

    private Stack<Integer> elements = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        elements.push(x);
        if (mins.isEmpty() || x <= mins.peek()) mins.push(x);
    }

    public void pop() {
        int el = elements.pop();
        if (!mins.isEmpty() && mins.peek() == el) mins.pop();
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
