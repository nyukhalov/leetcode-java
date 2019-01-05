package max_stack;

import java.util.*;

// https://leetcode.com/problems/max-stack/
class MaxStack {

    private Stack<Integer> stack = new Stack<>();
    private PriorityQueue<Integer> queue = new PriorityQueue<>(1, Collections.reverseOrder());

    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        stack.push(x);
        queue.add(x);
    }

    public int pop() {
        int ret = stack.pop();
        queue.remove(ret);
        return ret;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return queue.peek();
    }

    public int popMax() {
        int max = queue.remove();

        Stack<Integer> tmp = new Stack<>();
        int el;
        do {
            el = stack.pop();
            tmp.push(el);
        } while(el != max);

        tmp.pop();
        while(!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }

        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
