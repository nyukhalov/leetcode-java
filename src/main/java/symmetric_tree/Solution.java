package symmetric_tree;

// https://leetcode.com/problems/symmetric-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrored(root.left, root.right);
    }

    private boolean isMirrored(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        // both are not null
        return left.val == right.val && isMirrored(left.left, right.right) && isMirrored(left.right, right.left);
    }
}
