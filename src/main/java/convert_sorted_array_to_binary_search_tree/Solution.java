package convert_sorted_array_to_binary_search_tree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int from, int to) {
        int diff = to - from;
        if (diff < 0) return null;
        else {
            int rootIdx = from + (diff / 2);
            TreeNode node = new TreeNode(nums[rootIdx]);
            node.left = build(nums, from, rootIdx - 1);
            node.right = build(nums, rootIdx + 1, to);
            return node;
        }
    }
}
