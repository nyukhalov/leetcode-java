package palindrome_linked_list;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// https://leetcode.com/problems/palindrome-linked-list/
class Solution {
    public boolean isPalindrome(ListNode head) {
        int size = getSize(head);
        if (size <= 1) return true;
        Stack<Integer> stack = new Stack<>();
        int hSize = size / 2;
        ListNode node = head;
        int cnt = 0;
        while(node != null) {
            if (cnt < hSize) {
                stack.push(node.val);
            } else if (size - cnt <= hSize) {
                if (stack.pop() != node.val) return false;
            }
            cnt++;
            node = node.next;
        }
        return true;
    }

    private int getSize(ListNode head) {
        ListNode node = head;
        int size = 0;
        while(node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
}
