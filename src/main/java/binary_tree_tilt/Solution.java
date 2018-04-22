package binary_tree_tilt;

// https://leetcode.com/problems/binary-tree-tilt/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int findTilt(TreeNode root) {
        replaceElementsByTilt(root);
        return findSumOfAllNodes(root);
    }

    // returns sum of tree values
    private int replaceElementsByTilt(TreeNode root) {
        if (root == null) return 0;
        int leftSum = replaceElementsByTilt(root.left);
        int rightSum = replaceElementsByTilt(root.right);
        int sum = root.val + leftSum + rightSum;
        root.val = Math.abs(leftSum - rightSum);
        return sum;
    }

    private int findSumOfAllNodes(TreeNode node) {
        if (node == null) return 0;
        return node.val + findSumOfAllNodes(node.left) + findSumOfAllNodes(node.right);
    }
}
