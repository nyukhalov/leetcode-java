package remove_linked_list_elements;

// https://leetcode.com/problems/remove-linked-list-elements/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode rHead = null;
        ListNode rLast = null;

        ListNode node = head;
        while(node != null) {
            if (node.val != val) {
                if (rHead == null) {
                    rHead = node;
                } else {
                    rLast.next = node;
                }
                rLast = node;
            }
            node = node.next;
        }

        if (rLast != null) {
            rLast.next = null;
        }

        return rHead;
    }
}
