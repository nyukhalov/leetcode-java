package binary_tree_level_order_traversal_ii;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    static class TreeNodeWithMeta {
        TreeNode node;
        int level;
        public TreeNodeWithMeta(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> topOrderedResult = levelOrderTop(root);
        Collections.reverse(topOrderedResult);
        return topOrderedResult;
    }

    private List<List<Integer>> levelOrderTop(TreeNode root) {
        List<List<Integer>> acc = new ArrayList<>();
        Queue<TreeNodeWithMeta> queue = new LinkedList<>();
        int prevLevel = 0;

        queue.add(new TreeNodeWithMeta(root, 1));

        while(!queue.isEmpty()) {
            TreeNodeWithMeta m = queue.poll();
            if (prevLevel == m.level) {
                acc.get(acc.size() - 1).add(m.node.val);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(m.node.val);
                acc.add(l);
                prevLevel = m.level;
            }
            if (m.node.left != null) queue.add(new TreeNodeWithMeta(m.node.left, m.level + 1));
            if (m.node.right != null) queue.add(new TreeNodeWithMeta(m.node.right, m.level + 1));
        }

        return acc;
    }
}
