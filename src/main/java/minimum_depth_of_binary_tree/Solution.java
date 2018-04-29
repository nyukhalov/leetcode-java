package minimum_depth_of_binary_tree;

import java.util.*;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    static class LeveledTreeNode {
        TreeNode node;
        int level;
        public LeveledTreeNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<LeveledTreeNode> queue = new LinkedList<>();
        queue.add(new LeveledTreeNode(root, 1));
        while(!queue.isEmpty()) {
            LeveledTreeNode n = queue.poll();
            if (n.node.left == null && n.node.right == null) return n.level;
            if (n.node.left != null) queue.add(new LeveledTreeNode(n.node.left, n.level + 1));
            if (n.node.right != null) queue.add(new LeveledTreeNode(n.node.right, n.level + 1));
        }
        return -1; // impossible
    }
}
