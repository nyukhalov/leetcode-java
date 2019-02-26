package balanced_binary_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// https://leetcode.com/problems/balanced-binary-tree/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int[] balDepth = checkIsBalanced(root);
        return balDepth[0] > 0;
    }

    private int[] checkIsBalanced(TreeNode root) {
        int[] res = new int[2];

        if (root == null) {
            res[0] = 1;
            return res;
        }

        int[] lres = checkIsBalanced(root.left);
        int[] rres = checkIsBalanced(root.right);

        if (lres[0] > 0 && rres[0] > 0) {
            if (Math.abs(lres[1]-rres[1]) <= 1) res[0] = 1;
        }
        res[1] = 1 + Math.max(lres[1], rres[1]);

        return res;
    }
}
