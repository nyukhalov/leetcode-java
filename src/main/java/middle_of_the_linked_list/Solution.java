package middle_of_the_linked_list;

// https://leetcode.com/problems/middle-of-the-linked-list/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode[] nodes = new ListNode[100];
        int size = 0;

        ListNode node = head;
        while(node != null) {
            nodes[size++] = node;
            node = node.next;
        }

        int mdlIdx = size / 2;
        return nodes[mdlIdx];
    }
}
