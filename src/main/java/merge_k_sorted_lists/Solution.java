package merge_k_sorted_lists;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int size = lists.length;
        while(size > 1) {
            size = divideAndConqueror(lists, size);
        }
        return lists[0];
    }

    private int divideAndConqueror(ListNode[] lists, int size) {
        int resLength = (size + 1) / 2;
        int maxIdx = size - 1;
        for (int i=0; i<resLength; i++) {
            int lidx = i*2;
            if (lidx == maxIdx) lists[i] = lists[lidx];
            else lists[i] = mergeLists(lists[lidx], lists[lidx + 1]);
        }
        return resLength;
    }

    private ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode tail = null;
        ListNode min = null;

        while(head1 != null || head2 != null) {
            if (head1 == null) min = head2;
            else if (head2 == null) min = head1;
            else if (head1.val < head2.val) min = head1;
            else min = head2;

            if (min == head1) head1 = head1.next;
            else head2 = head2.next;

            if (head == null) {
                head = tail = min;
            } else {
                tail.next = min;
                tail = min;
            }
        }

        return head;
    }
}
