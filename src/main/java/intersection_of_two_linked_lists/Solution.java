package intersection_of_two_linked_lists;

import java.util.*;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode node = headA;
        while(node != null) {
            s1.push(node);
            node = node.next;
        }
        node = headB;
        while(node != null) {
            s2.push(node);
            node = node.next;
        }
        ListNode res = null;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            ListNode n1 = s1.pop();
            ListNode n2 = s2.pop();
            if (n1 != n2) return res;
            res = n1;
        }
        return res;
    }
}
