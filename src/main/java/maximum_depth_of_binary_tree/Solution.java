package maximum_depth_of_binary_tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
