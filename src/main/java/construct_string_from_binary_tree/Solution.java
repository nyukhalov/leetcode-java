package construct_string_from_binary_tree;

// https://leetcode.com/problems/construct-string-from-binary-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left != null || t.right != null) {
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
        }
        if (t.right != null) {
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }
}
