package reverse_linked_list;

// https://leetcode.com/problems/reverse-linked-list/description/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next = head == null ? null : head.next;
        ListNode prev = null;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur.next = prev;
            prev = cur;
            cur = next;
            next = nextNext;
        }
        return cur;
    }
}
