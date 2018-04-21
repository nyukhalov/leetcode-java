package two_sum_iv_input_is_a_bst;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTargetRec(root, root, k);
    }

    private boolean findTargetRec(TreeNode root, TreeNode node, int k) {
        if (node == null) return false;
        int diff = k - node.val;
        if (existsAnother(root, diff, node)) return true;
        if (findTargetRec(root, node.right, k)) return true;
        if (findTargetRec(root, node.left, k)) return true;
        return false;
    }

    private boolean existsAnother(TreeNode node, int val, TreeNode exclude) {
        if (node == null || node == exclude) return false;
        if (node.val == val) return true;
        if (val < node.val && existsAnother(node.left, val, exclude)) return true;
        if (val > node.val && existsAnother(node.right, val, exclude)) return true;
        return false;
    }
}
