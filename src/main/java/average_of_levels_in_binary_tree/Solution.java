package average_of_levels_in_binary_tree;

import java.util.*;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    static class Tuple {
        public Tuple(double avg, int count) {
            this.avg = avg;
            this.count = count;
        }

        public double avg = 0;
        public int count = 0;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Tuple> tuples = new ArrayList<>();
        process(tuples, root, 0);

        List<Double> result = new ArrayList<>();
        for (Tuple t : tuples) {
            result.add(t.avg);
        }
        return result;
    }

    private void process(List<Tuple> tuples, TreeNode node, int level) {
        if (node == null) return;
        if (level >= tuples.size()) {
            tuples.add(new Tuple(node.val, 1));
        } else {
            Tuple t = tuples.get(level);
            t.count += 1;
            t.avg = t.avg + ((node.val - t.avg) / t.count);
        }
        process(tuples, node.left, level + 1);
        process(tuples, node.right, level + 1);
    }
}
