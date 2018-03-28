package implement_queue_using_stacks;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
class MyQueue {

    private Stack<Integer> receiverSlack = new Stack<>();
    private Stack<Integer> senderStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        receiverSlack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        syncStacks();
        return senderStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        syncStacks();
        return senderStack.peek();
    }

    private void syncStacks() {
        if (senderStack.isEmpty()) {
            while (!receiverSlack.empty()) {
                senderStack.push(receiverSlack.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return receiverSlack.isEmpty() && senderStack.empty();
    }
}

