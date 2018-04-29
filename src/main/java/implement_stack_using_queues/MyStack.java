package implement_stack_using_queues;

import java.util.*;

// https://leetcode.com/problems/implement-stack-using-queues/description/
class MyStack {

    private Queue<Integer> pushQueue = new LinkedList<>();
    private Queue<Integer> popQueue = new LinkedList<>();
    private int removed = 0;

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        int keepCnt = pushQueue.size() - removed;
        for (int i=0; i<keepCnt; i++) pushQueue.add(pushQueue.poll());
        for (int i=0; i<removed; i++) pushQueue.poll();
        removed = 0;

        pushQueue.add(x);
        popQueue.clear();
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        removed++;
        refill();
        return popQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        refill();
        return popQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return pushQueue.isEmpty() && popQueue.isEmpty();
    }

    private void refill() {
        if (popQueue.isEmpty()) {
            while(!pushQueue.isEmpty()) {
                int size = pushQueue.size();
                for (int i=0; i<size-1; i++) {
                    // rotate queue to get the last element
                    pushQueue.add(pushQueue.poll());
                }
                popQueue.add(pushQueue.poll());
            }
        }
    }
}
