package remove_duplicates_from_sorted_list;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
