package subtree_of_another_tree;

// https://leetcode.com/problems/subtree-of-another-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isEquals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isEquals(TreeNode s, TreeNode t) {
        if (s == t) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isEquals(s.left, t.left) && isEquals(s.right, t.right);
    }
}
