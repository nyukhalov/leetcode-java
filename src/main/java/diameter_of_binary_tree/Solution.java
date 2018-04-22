package diameter_of_binary_tree;

// https://leetcode.com/problems/diameter-of-binary-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverseTree(root);
        return maxDiameter;
    }

    // return the max path of tree
    private int traverseTree(TreeNode root) {
        if (root == null) return 0;
        int leftPath = traverseTree(root.left);
        int rightPath = traverseTree(root.right);
        int diameter = leftPath + rightPath;
        if (diameter > maxDiameter) maxDiameter = diameter;
        return Math.max(leftPath, rightPath) + 1;
    }
}
