package linked_list_cycle;

// https://leetcode.com/problems/linked-list-cycle/description/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode trap = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            if (next == trap) return true;
            head.next = trap;
            head = next;
        }
        return false;
    }
}
