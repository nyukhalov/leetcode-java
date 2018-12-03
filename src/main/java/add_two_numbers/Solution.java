package add_two_numbers;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// https://leetcode.com/problems/add-two-numbers/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode prev = null;
        int add = 0;
        while(l1 != null || l2 != null) {
            int sum = add;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            add = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            if (prev == null) {
                root = prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
        }
        if (add > 0) {
            ListNode node = new ListNode(add);
            prev.next = node;
        }
        return root;
    }
}
