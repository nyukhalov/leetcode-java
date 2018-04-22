package sum_of_left_leaves;

// https://leetcode.com/problems/sum-of-left-leaves/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesRec(root, false);
    }

    private int sumOfLeftLeavesRec(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return isLeft ? node.val : 0;
        return sumOfLeftLeavesRec(node.left, true) + sumOfLeftLeavesRec(node.right, false);
    }
}
