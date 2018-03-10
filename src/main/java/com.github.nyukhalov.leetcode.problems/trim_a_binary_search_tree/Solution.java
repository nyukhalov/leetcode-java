package com.github.nyukhalov.leetcode.problems.trim_a_binary_search_tree;

// https://leetcode.com/problems/trim-a-binary-search-tree/description/
class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        else if (root.val < L) return trimBST(root.right, L, R);
        else if (root.val > R) return trimBST(root.left, L, R);
        else {
            root.right = trimBST(root.right, L, R);
            root.left = trimBST(root.left, L, R);
            return root;
        }
    }
}