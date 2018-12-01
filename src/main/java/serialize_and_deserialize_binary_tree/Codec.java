package serialize_and_deserialize_binary_tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                sb.append("null");
                sb.append(",");
            } else {
                sb.append(node.val);
                sb.append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) return null;
        TreeNode root = null;
        String[] tokens = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i=0; i<tokens.length; i++) {
            String token = tokens[i];
            if (i == 0) {
                root = fromToken(token);
                queue.add(root);
            } else {
                TreeNode parent = queue.remove();
                TreeNode left = fromToken(token);
                TreeNode right = fromToken(tokens[i + 1]);
                parent.left = left;
                parent.right = right;
                if (left != null) queue.add(left);
                if (right != null) queue.add(right);
                i++;
            }
        }
        return root;
    }

    private TreeNode fromToken(String token) {
        if (token == null || "null".equals(token)) return null;
        return new TreeNode(Integer.parseInt(token));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
