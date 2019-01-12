package binary_tree_paths;

import java.util.*;

// https://leetcode.com/problems/binary-tree-paths/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        binaryTreePathsRec(root, "", ret);
        return ret;
    }

    private void binaryTreePathsRec(TreeNode node, String prefix, List<String> ret) {
        if (node == null) return;
        prefix += Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            ret.add(prefix);
        } else {
            prefix += "->";
            binaryTreePathsRec(node.left, prefix, ret);
            binaryTreePathsRec(node.right, prefix, ret);
        }
    }
}
