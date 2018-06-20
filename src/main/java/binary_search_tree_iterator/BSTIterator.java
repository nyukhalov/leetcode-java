package binary_search_tree_iterator;

import java.util.*;

// https://leetcode.com/problems/binary-search-tree-iterator/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {

    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addLeftIfNotEmpty(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = stack.pop();
        addLeftIfNotEmpty(n.right);
        return n.val;
    }

    private void addLeftIfNotEmpty(TreeNode n) {
        if (n != null) {
            stack.push(n);
            while(n.left != null) {
                stack.push(n.left);
                n = n.left;
            }
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
