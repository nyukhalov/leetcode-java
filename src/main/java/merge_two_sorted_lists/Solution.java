package merge_two_sorted_lists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// https://leetcode.com/problems/merge-two-sorted-lists/description/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode root = null;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            int v = 0;
            if (l1.val < l2.val) {
                v = l1.val;
                l1 = l1.next;
            }
            else {
                v = l2.val;
                l2 = l2.next;
            }
            ListNode n = new ListNode(v);
            if (prev == null) root = n;
            else prev.next = n;
            prev = n;
        }

        while (l1 != null) {
            ListNode n = new ListNode(l1.val);
            prev.next = n;
            prev = n;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode n = new ListNode(l2.val);
            prev.next = n;
            prev = n;
            l2 = l2.next;
        }

        return root;
    }
}
