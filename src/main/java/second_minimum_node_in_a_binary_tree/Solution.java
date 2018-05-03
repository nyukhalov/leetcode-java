package second_minimum_node_in_a_binary_tree;

// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    int min = Integer.MAX_VALUE;
    int secondMin = min;

    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        if (secondMin == min || secondMin == Integer.MAX_VALUE) return -1;
        else return secondMin;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        if (node.val < min) {
            secondMin = min;
            min = node.val;
        } else if (node.val < secondMin && node.val != min) {
            secondMin = node.val;
        }
        findSecondMinimumValue(node.left);
        findSecondMinimumValue(node.right);
    }
}
