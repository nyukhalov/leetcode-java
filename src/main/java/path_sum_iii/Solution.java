package path_sum_iii;

// https://leetcode.com/problems/path-sum-iii/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return
                seqPathSum(root, sum) +
                        pathSum(root.left, sum) +
                        pathSum(root.right, sum);
    }

    private int seqPathSum(TreeNode node, int sum) {
        if (node == null) return 0;
        int add = 0;
        if (node.val == sum) add = 1;
        return
                add +
                        seqPathSum(node.left, sum-node.val) +
                        seqPathSum(node.right, sum-node.val);
    }
}
