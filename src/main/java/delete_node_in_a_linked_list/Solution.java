package delete_node_in_a_linked_list;

// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
